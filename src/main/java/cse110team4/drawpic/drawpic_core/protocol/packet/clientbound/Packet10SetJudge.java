package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

public class Packet10SetJudge extends Packet {
	final static byte SET_JUDGE_ID = 0x10;
	
	private String judge;
	
	public Packet10SetJudge() {
		super(SET_JUDGE_ID);
	}
	
	public Packet10SetJudge(String judge) {
		this();
		
		this.judge = judge;
	}
	
	public String getJudge() {
		return judge;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		judge = reader.readString();
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeString(judge);
	}
}
