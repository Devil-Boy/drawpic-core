package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This packet notifies the server that this client is disconnecting properly
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class Packet06Disconnect extends Packet {
	final static byte DISCONNECT_ID = 0x06;
	
	/**
	 * Constructs this packet
	 */
	public Packet06Disconnect() {
		super(DISCONNECT_ID);
	}
	
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		// This packet has no body so write nothing
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		// Do nothing because there's no message body in this packet
	}
}
