package cse110team4.drawpic.drawpic_core.drawing;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

public class Blot extends Step {
	static final byte BLOT_ID = 0x03;

	private Location location;
	
	public Blot() {
		super(BLOT_ID);
	}
	
	public Blot(Location location) {
		this();
		
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		location = Location.fromStream(reader);
	}

	@Override
	public void writeStepToStream(StreamWriter writer) throws StreamWriteException {
		location.writeToStream(writer);
	}
}
