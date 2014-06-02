package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.lobby.Lobby;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet used to signal a player joining a certain lobby
 * @author Kirk
 *
 */
public class Packet0AJoinLobby extends Packet{
	
	private Lobby lobby;
	
	final static byte JOIN_LOBBY = 0x0A;
	
	/**
	 * Default constructor
	 */
	public Packet0AJoinLobby() {
		super(JOIN_LOBBY);
	}
	
	/**
	 * Constructs a packet to indicate joining a lobby
	 * @param username to be sent with packet indicating user joining lobby
	 */
	public Packet0AJoinLobby(Lobby lobby){
		super(JOIN_LOBBY);
		this.lobby = lobby;
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		// Not needed
		
	}
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		lobby.writeToStream(writer);
		
	}

}
