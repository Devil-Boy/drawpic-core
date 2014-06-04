package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This packet is sent to the server to indicate what the user chose in relation to lobbies
 * 
 * @author Devil Boy (Kervin Sam)
 *
 */
public class Packet04KickLobby extends Packet {
	final static byte LOGIN_ID = 0x04;
	
	private String reason;

	/**
	 * Constructor that doesn't set any initial values
	 */
	public Packet04KickLobby() {
		super(LOGIN_ID);
	}
	
	public Packet04KickLobby(String r) {
		super(LOGIN_ID);
		reason = r;
	}

	
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeString(reason);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		reader.readString();
	}
}
