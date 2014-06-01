/**
 * 
 */
package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet to be sent to clients indicating that a player has left
 * @author Kirk
 *
 */
public class Packet0DPlayerLeft extends Packet {

	final static byte PLAYER_LEFT = 0x0D;
	private String username;
	
	/**
	 * Default arg constructor
	 */
	public Packet0DPlayerLeft() {
		super(PLAYER_LEFT);
	}

	public Packet0DPlayerLeft(String username){
		super(PLAYER_LEFT);
		this.username = username;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeString(username);

	}

}
