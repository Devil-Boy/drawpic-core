package cse110team4.drawpic.drawpic_core.drawing;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.Streamable;

public abstract class Step implements Streamable {
	private byte id;
	
	public Step(byte id) {
		this.id = id;
	}
	
	@Override
	public void writeToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeByte(id);
		
		writeStepToStream(writer);
	}
	
	public abstract void writeStepToStream(StreamWriter writer) throws StreamWriteException;
	
	public static Step fromStream(StreamReader reader) throws StreamReadException {
		byte id = reader.readByte();
		
		Step step = null;
		switch (id) {
		case 0x01:
			step = new Pen();
			break;
		case 0x02:
			step = new Eraser();
			break;
		case 0x03:
			step = new Blot();
			break;
		case 0x04:
			step = new Line();
			break;
		}
		
		step.readFromStream(reader);
		return step;
	}
}
