package cse110team4.drawpic.drawpic_core.protocol.packet;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional.PacketConnect;
import cse110team4.drawpic.drawpic_core.protocol.packet.clientbound.PacketLoginResponse;
import cse110team4.drawpic.drawpic_core.protocol.packet.serverbound.PacketLogin;

/**
 * This is in charge of parsing packets from the stream reader
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PacketParser {
	private StreamReader reader;
	
	/**
	 * Constructs this parser with the given stream reader
	 * @param reader The reader that contains the packet data
	 */
	public PacketParser(StreamReader reader) {
		this.reader = reader;
	}

	public Packet parsePacket() throws StreamReadException {
		// Get the packet's id
		byte id = reader.readByte();
		
		Packet packet = null;
		if (id == 0x01) {
			packet = new PacketConnect();
		} else if (id == 0x02) {
			packet = new PacketLogin();
		} else if (id == 0x03) {
			packet = new PacketLoginResponse();
		}
		
		if (packet == null) {
			// TODO: Handle unknown packet ids
		} else {
			packet.readFromStream(reader);
		}
		
		return packet;
	}
}
