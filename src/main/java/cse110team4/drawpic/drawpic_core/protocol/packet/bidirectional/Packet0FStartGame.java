/**
 * 
 */
package cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet to indicate to server and users that game is ready to start
 * @author Kirk
 *
 */
public class Packet0FStartGame extends Packet {

	final static byte START_GAME = 0x0F;
	
	/**
	 * Default constructor
	 */
	public Packet0FStartGame() {
		super(START_GAME);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		//Not Needed

	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		// Not Needed

	}

}
