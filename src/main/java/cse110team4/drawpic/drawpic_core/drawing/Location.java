package cse110team4.drawpic.drawpic_core.drawing;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.Streamable;

public class Location implements Streamable {

	private int xPos;
	private int yPos;
	
	public Location() {
	}
	
	public Location(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}

	@Override
	public void writeToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeInt(xPos);
		writer.writeInt(yPos);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		xPos = reader.readInt();
		yPos = reader.readInt();
	}
	
	public static Location fromStream(StreamReader reader) throws StreamReadException {
		Location location = new Location();
		location.readFromStream(reader);
		return location;
	}
}
