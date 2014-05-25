package cse110team4.drawpic.drawpic_core.protocol.packet;

import cse110team4.drawpic.drawpic_core.protocol.Streamable;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

/**
 * This represents a message to be sent over the network
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public abstract class Packet implements Streamable {
	private byte id;
	
	/**
	 * Sets the type ID of this packet
	 */
	public Packet(byte id) {
		this.id = id;
	}
	
	/**
	 * Gets the type ID of this packet
	 * @return A byte representing the type of packet this is
	 */
	public byte getID() {
		return id;
	}
	
	@Override
	public void writeToStream(StreamWriter writer) throws StreamWriteException {
		// Write the packet type
		writer.writeByte(id);
		
		// Write the packet body
		writeBodyToStream(writer);
	}
	
	/**
	 * Write the packet body using the given writer
	 * @param writer The writer to use
	 * @throws StreamWriteException if there was a write error
	 */
	public abstract void writeBodyToStream(StreamWriter writer) throws StreamWriteException;
}
