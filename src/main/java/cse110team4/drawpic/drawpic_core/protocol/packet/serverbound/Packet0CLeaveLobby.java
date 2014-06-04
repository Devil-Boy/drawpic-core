/**
 * 
 */
package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet to send to server that user has left the lobby.
 * @author Kirk
 *
 */
public class Packet0CLeaveLobby extends Packet {

	final static byte LEAVE_LOBBY = 0x0C;
	
	/**
	 * Default no arg constructor
	 */
	public Packet0CLeaveLobby() {
		super(LEAVE_LOBBY);
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
	}

	
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
	}

}
