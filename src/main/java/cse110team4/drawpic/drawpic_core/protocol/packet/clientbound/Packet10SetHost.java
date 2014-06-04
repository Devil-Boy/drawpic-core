package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

public class Packet10SetHost extends Packet {
	final static byte SET_HOST_ID = 0x10;
	
	private String host;
	
	public Packet10SetHost() {
		super(SET_HOST_ID);
	}
	
	public Packet10SetHost(String host) {
		this();
		
		this.host = host;
	}
	
	public String getHost() {
		return host;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		host = reader.readString();
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeString(host);
	}
}
