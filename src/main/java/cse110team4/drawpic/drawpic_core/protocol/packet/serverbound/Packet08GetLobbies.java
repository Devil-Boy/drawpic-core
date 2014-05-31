package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet sent to server that indicates client would like a list of the lobbies
 * @author Kirk
 *
 */

public class Packet08GetLobbies extends Packet {
	final static byte GET_LOBBIES_ID = 0x08;
	
	/**
	 * Default constructor
	 */
	public Packet08GetLobbies() {
		super(GET_LOBBIES_ID);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		//No data to be read

	}

	@Override
	public void writeBodyToStream(StreamWriter writer)
			throws StreamWriteException {
		//No extra data to be written

	}

}
