package cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This is the initial connection packet
 * It will be the first packet sent to the server to notify it of a client's existence
 * It will also be sent back to the client for acknowledgment
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PacketConnect extends Packet {
	final static byte CONNECT_ID = 0x01;
	
	/**
	 * Constructs a new PacketConnect object
	 */
	public PacketConnect() {
		super(CONNECT_ID);
	}

	/**
	 * Writes this packet's body to the given message
	 * Because this packet has no body, it does nothing here
	 */
	@Override
	public void writeBodyToMessage(StreamMessage message) throws JMSException {
		// This packet has no body
	}
	
	/**
	 * Reads this packet from the given message
	 * This packet doesn't have a message body, so this method only constructs a new object
	 * @param message The message to read from
	 * @return A PacketConnect object
	 * @throws JMSException if there was a read failure
	 */
	public static PacketConnect readFromMessage(StreamMessage message) throws JMSException {
		return new PacketConnect();
	}
}
