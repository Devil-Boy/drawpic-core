package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet to indicate a player (by username) has joined a game.
 * @author Kirk
 *
 */
public class Packet0BPlayerJoined extends Packet {

	final static byte PLAYER_JOINED= 0x0B;
	String username;
	
	/**
	 * Default no arg constructor
	 * 
	 */
	public Packet0BPlayerJoined() {
		super(PLAYER_JOINED);
	}

	/**
	 * Constructor to store passed in username
	 * @param username
	 */
	public Packet0BPlayerJoined(String username){
		super(PLAYER_JOINED);
		
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
