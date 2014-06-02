package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.Lobby;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

public class Packet05Lobby extends Packet {
	final static byte LOBBY_ID = 0x05;
	
	private Lobby lobby;
	
	public Packet05Lobby() {
		super(LOBBY_ID);
	}
	
	public Packet05Lobby(Lobby lobby) {
		this();
		this.lobby = lobby;
	}
	
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		// Write the lobby to stream
		lobby.writeToStream(writer);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		lobby = Lobby.fromStream(reader);
	}
}
