package cse110team4.drawpic.drawpic_core.drawing;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

public class Eraser extends Step {
	static final byte ERASER_ID = 0x02;

	private int size;
	
	public Eraser() {
		super(ERASER_ID);
	}
	
	public Eraser(int size) {
		this();
		
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		size = reader.readInt();
	}

	@Override
	public void writeStepToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeInt(size);
	}
}
