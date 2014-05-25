package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
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
	 * Constructor that doesn't set any initial values
	 */
	public PacketLogin() {
		super(LOGIN_ID);
	}
	
	/**
	 * Constructs with packet with the given username
	 */
	public PacketLogin(String username) {
		this();
		
		this.username = username;
	}
	
	/**
	 * Gets the username in this packet
	 * @return A String username
	 */
	public String getUsername() {
		return username;
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		// Write the username
		writer.writeString(username);
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		username = reader.readString();
	}
}
