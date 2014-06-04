package cse110team4.drawpic.drawpic_core.drawing;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

public class Line extends Step {
	static final byte LINE_ID = 0x04;

	private Location start, end;
	
	public Line() {
		super(LINE_ID);
	}
	
	public Line(Location start, Location end) {
		this();
		
		this.start = start;
		this.end = end;
	}
	
	public Location getStart() {
		return start;
	}
	
	public Location getEnd() {
		return end;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		start = Location.fromStream(reader);
		end = Location.fromStream(reader);
	}

	@Override
	public void writeStepToStream(StreamWriter writer) throws StreamWriteException {
		start.writeToStream(writer);
		end.writeToStream(writer);
	}
}
