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
	private String correlationID;
	
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
	
	/**
	 * Sets the correlation ID of this packet
	 * This can be used to match packets with their corresponding reply packets
	 * @param correlationID The correlation ID to use
	 */
	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
	}
	
	/**
	 * Gets the correlation ID the packet has set
	 * @return The correlation ID of this packet or null if there isn't one set
	 */
	public String getCorrelationID() {
		return correlationID;
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
