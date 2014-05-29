package cse110team4.drawpic.drawpic_core.protocol.packet;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PacketReply<T extends Packet> implements Future<T>, PacketHandler {
	
	private static enum State {WAITING, DONE, CANCELLED}
	
	private final BlockingQueue<T> reply;
	private volatile State state;
	
	private PacketReceiver receiver;
	private byte packetType;
	private String correlationID;
	
	public PacketReply(PacketReceiver receiver, byte packetType, String correlationID) {
		this.receiver = receiver;
		this.packetType = packetType;
		this.correlationID = correlationID;
		
		// Initialize variables
		reply = new ArrayBlockingQueue<>(1);
		state = State.WAITING;
		
		// Add self to packet handlers
		receiver.addPacketHandler(this);
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		state = State.CANCELLED;
		cleanUp();
		return true;
	}

	@Override
	public boolean isCancelled() {
		return state == State.CANCELLED;
	}

	@Override
	public boolean isDone() {
		return state == State.DONE;
	}

	@Override
	public T get() throws InterruptedException, ExecutionException {
		return this.reply.take();
	}

	@Override
	public T get(long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		final T queueResult = reply.poll(timeout, unit);
		if (queueResult == null) {
			throw new TimeoutException();
		}
		return queueResult;
	}

	@Override
	public void handlePacket(Packet packet) {
		// Check the packet type
		if (packet.getID() == packetType) {
			// Check the correlation ID
			if (packet.getCorrelationID() != null && packet.getCorrelationID().equals(correlationID)) {
				try {
					// Set this packet as the reply we wanted
					reply.put((T) packet);
				} catch (InterruptedException e) {
					// We got interrupted while trying to set the reply
					e.printStackTrace();
				}
			}
		}
	}
	
	private void cleanUp() {
		receiver.removePacketHandler(this);
	}
}