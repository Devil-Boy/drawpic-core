/**
 * 
 */
package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import java.util.ArrayList;
import java.util.List;

import cse110team4.drawpic.drawpic_core.Lobby;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet to send a list of the lobbies to the client
 * 
 * @author Kirk
 *
 */
public class Packet09LobbyList extends Packet{

	final static byte LOBBY_LIST = 0x09;
	private List<Lobby> lobbies;
	
	/**
	 * Default constructor
	 */
	public Packet09LobbyList() {
		super(LOBBY_LIST);
	}

	public Packet09LobbyList(List<Lobby> lobbies){
		super(LOBBY_LIST);
		this.lobbies = lobbies;
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		//Lobby lobby = new Lobby();
		
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		for(Lobby lobby : lobbies){
			lobby.writeToStream(writer);
		}
		
	}

}
