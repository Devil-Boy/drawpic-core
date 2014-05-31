package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;
/**
 * This packet is sent to the server when a player creates a lobby.
 * 
 * @author Kirk
 *
 */

public class Packet07CreateLobby extends Packet{
	final static byte LOBBY_ID = 0x07;
	
	/**
	 * Constructor that sets no initial vales
	 */
	public Packet07CreateLobby(){
		super(LOBBY_ID);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		// No data read
		
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		// No data written
		
	}
}
