package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

public class Packet12GamePhase extends Packet {
	final static byte GAME_PHASE_ID = 0x12;
	
	String phase;

	public Packet12GamePhase() {
		super(GAME_PHASE_ID);
	}
	
	public Packet12GamePhase(String s) {
		super(GAME_PHASE_ID);
		
		phase = s;
	}	

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		phase = reader.readString();
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeString(phase);
	}
}
