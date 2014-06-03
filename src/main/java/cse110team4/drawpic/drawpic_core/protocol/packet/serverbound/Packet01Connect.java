package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This is the initial connection packet
 * It will be the first packet sent to the server to notify it of a client's existence
 * It will also be sent back to the client for acknowledgment
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class Packet01Connect extends Packet {
	final static byte CONNECT_ID = 0x01;
	
	/**
	 * Constructs a new PacketConnect object
	 */
	public Packet01Connect() {
		super(CONNECT_ID);
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
