package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This packet is sent to the server when the player attempts to login with a desired username
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PacketLogin extends Packet {
	final static byte LOGIN_ID = 0x02;
	
	private String username;
	
	/**
	 * Private constructor that doesn't set any values
	 */
	private PacketLogin() {
		super(LOGIN_ID);
	}
	
	/**
	 * Constructs with packet with the given username
	 */
	public PacketLogin(String username) {
		super(LOGIN_ID);
		
		this.username = username;
	}
	
	/**
	 * Gets the username in this packet
	 * @return A String username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Writes the username to the message
	 * @param message The message to write to
	 * @throws JMSException if there is a write failure
	 */
	@Override
	public void writeBodyToMessage(StreamMessage message) throws JMSException {
		// Write the username
		message.writeString(username);
	}
	
	/**
	 * Reads this packet from the given message
	 * @param message The message to read from
	 * @return A PacketLogin object containing information from the given message
	 * @throws JMSException if there was a read failure
	 */
	public static PacketLogin readFromMessage(StreamMessage message) throws JMSException {
		PacketLogin packet = new PacketLogin();
		packet.username = message.readString();
		return packet;
	}
}
