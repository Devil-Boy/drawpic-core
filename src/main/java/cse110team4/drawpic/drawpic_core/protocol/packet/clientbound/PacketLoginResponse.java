package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This packet represents a response to a login attempt
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PacketLoginResponse extends Packet {
	final static byte LOGIN_RESPONSE_ID = 0x03;
	
	private boolean loginSuccess;
	private String failReason;
	
	/**
	 * Private constructor that makes this packet without any set values
	 */
	private PacketLoginResponse() {
		super(LOGIN_RESPONSE_ID);
	}
	
	/**
	 * Constructs a new login response
	 * @param loginSuccess Whether or not the login was successful
	 * @param failReason The reason for login failure (if any)
	 */
	public PacketLoginResponse(boolean loginSuccess, String failReason) {
		super(LOGIN_RESPONSE_ID);
		
		this.loginSuccess = loginSuccess;
		this.failReason = failReason;
	}
	
	/**
	 * Gets whether or not the login was successful
	 * @return The login's success
	 */
	public boolean getLoginSuccess() {
		return loginSuccess;
	}
	
	/**
	 * Gets the reason for failure
	 * @return A String for the failure. If login was successful, behavior undefined (most likely returns null)
	 */
	public String getFailReason() {
		return failReason;
	}

	/**
	 * Write whether or not the login was successful and a failure reason if applicable
	 * @param message The message to write to
	 * @throws JMSException if there was a write failure
	 */
	@Override
	public void writeBodyToMessage(StreamMessage message) throws JMSException {
		// Write whether or not login was successful
		message.writeBoolean(loginSuccess);
		
		if (!loginSuccess) {
			// Write the reason the login failed
			message.writeString(failReason);
		}
	}
	
	/**
	 * Reads this packet from the given message
	 * @param message The message to read from
	 * @return A PacketLoginResponse object with a state determined by the message data
	 * @throws JMSException if there was a read failure
	 */
	public static PacketLoginResponse readFromMessage(StreamMessage message) throws JMSException {
		PacketLoginResponse packet = new PacketLoginResponse();
		packet.loginSuccess = message.readBoolean();
		if (!packet.loginSuccess) {
			packet.failReason = message.readString();
		}
		return packet;
	}
}
