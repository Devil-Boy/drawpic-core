package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.player.Lobby;
import cse110team4.drawpic.drawpic_core.player.LobbyParser;
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
	
	/**
	 * Gets lobby object
	 * @return A Lobby
	 */
	public Lobby getLobby(){
		return this.lobby;
	}
	
	/**
	 * Gets the host of the joined lobby
	 * @return The String name of the lobby host
	 */
	public String getLobbyHost() {
		return this.lobby.getHost();
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		lobby = CoreBeans.getContext().getBean(LobbyParser.class).fromStream(reader);
	}
	
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		lobby.writeToStream(writer);
	}

}
