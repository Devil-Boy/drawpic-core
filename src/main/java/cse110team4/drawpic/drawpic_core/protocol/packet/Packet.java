package cse110team4.drawpic.drawpic_core.protocol.packet;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.Messageable;
import cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional.PacketConnect;
import cse110team4.drawpic.drawpic_core.protocol.packet.clientbound.PacketLoginResponse;
import cse110team4.drawpic.drawpic_core.protocol.packet.serverbound.PacketLogin;

/**
 * This represents a message to be sent over the network
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public abstract class Packet implements Messageable {
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
	
	/**
	 * Writes the packet information to the given message
	 * @param message The message to write to
	 * @throws JMSException if there was a write failure
	 */
	public void writeToMessage(StreamMessage message) throws JMSException {
		// Write the packet type
		message.writeByte(id);
		
		// Write the packet body
		writeBodyToMessage(message);
	}
	
	/**
	 * Write the packet body to the given message
	 * @param message The message to write to
	 * @throws JMSException if there was a write failure
	 */
	public abstract void writeBodyToMessage(StreamMessage message) throws JMSException;
	
	/**
	 * Gets a packet from the given message
	 * @param message The message containing the packet
	 * @return The packet that was in the message, null if the packet ID was unknown
	 * @throws JMSException if there was an error reading the message
	 */
	public static Packet readFromMessage(StreamMessage message) throws JMSException {
		byte packetID = message.readByte();
		
		if (packetID == 0x01) {
			return PacketConnect.readFromMessage(message);
		} else if (packetID == 0x02) {
			return PacketLogin.readFromMessage(message);
		} else if (packetID == 0x03) {
			return PacketLoginResponse.readFromMessage(message);
		} else {
			// Received unknown packet type
			return null;
		}
	}
}
