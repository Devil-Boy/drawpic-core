package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This packet represents a response to a login attempt
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class Packet03Response extends Packet {
	final static byte LOGIN_RESPONSE_ID = 0x03;
	
	private boolean success;
	private String failReason;
	
	/**
	 * Constructs this packet without any set values
	 */
	public Packet03Response() {
		super(LOGIN_RESPONSE_ID);
	}
	
	/**
	 * Constructs a new login response
	 * @param success Whether or not the login was successful
	 * @param failReason The reason for login failure (if any)
	 */
	public Packet03Response(boolean success, String failReason) {
		this();
		
		this.success = success;
		this.failReason = failReason;
	}
	
	/**
	 * Gets whether or not the login was successful
	 * @return The login's success
	 */
	public boolean getSuccess() {
		return success;
	}
	
	/**
	 * Gets the reason for failure
	 * @return A String for the failure. If login was successful, behavior undefined (most likely returns null)
	 */
	public String getFailReason() {
		return failReason;
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		// Write whether or not login was successful
		writer.writeBoolean(success);
		
		if (!success) {
			// Write the reason the login failed
			writer.writeString(failReason);
		}
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		success = reader.readBoolean();
		if (!success) {
			failReason = reader.readString();
		}
	}
}
