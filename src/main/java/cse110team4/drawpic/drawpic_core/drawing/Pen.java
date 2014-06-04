package cse110team4.drawpic.drawpic_core.drawing;

import java.awt.Color;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

public class Pen extends Step implements Tool {
	static final byte PEN_ID = 0x01;

	private Color color;
	private int size;
	
	public Pen() {
		super(PEN_ID);
	}
	
	public Pen(Color color, int size) {
		this();
		
		this.color = color;
		this.size = size;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		color = new Color(reader.readInt());
		size = reader.readInt();
	}

	@Override
	public void writeStepToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeInt(color.getRGB());
		writer.writeInt(size);
	}
}
