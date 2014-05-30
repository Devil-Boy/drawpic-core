package cse110team4.drawpic.drawpic_core.protocol.packet;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional.*;
import cse110team4.drawpic.drawpic_core.protocol.packet.clientbound.*;
import cse110team4.drawpic.drawpic_core.protocol.packet.serverbound.*;

/**
 * This is in charge of parsing packets from the stream reader
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PacketParser {

	public static Packet parsePacket(StreamReader reader) throws StreamReadException {
		// Get the packet's id
		byte id = reader.readByte();
		
		Packet packet = null;
		if (id == 0x01) {
			packet = new Packet01Connect();
		} else if (id == 0x02) {
			packet = new Packet02Login();
		} else if (id == 0x03) {
			packet = new Packet03LoginResponse();
		} else if (id == 0x04) {
			packet = new Packet04LobbyOption();
		} else if (id == 0x05) {
			packet = new Packet05Lobby();
		} else if (id == 0x06) {
			packet = new Packet06Disconnect();
		}
		
		if (packet == null) {
			// TODO: Handle unknown packet ids
		} else {
			packet.readFromStream(reader);
		}
		
		return packet;
	}
}
