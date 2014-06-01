package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet used to signal a player joining
 * @author Kirk
 *
 */
public class Packet0aJoinLobby extends Packet{
	
	private String username;
	
	final static byte JOIN_LOBBY = 0x0a;
	
	/**
	 * Default constructor
	 */
	public Packet0aJoinLobby() {
		super(JOIN_LOBBY);
	}
	
	/**
	 * Constructs a packet to indicate joining a lobby
	 * @param username to be sent with packet indicating user joining lobby
	 */
	public Packet0aJoinLobby(String username){
		super(JOIN_LOBBY);
		this.username = username;
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		// Not needed
		
	}
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeString(username);
		
	}

}
