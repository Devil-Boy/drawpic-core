package cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional;

import cse110team4.drawpic.drawpic_core.drawing.Step;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

public class Packet13SingleStep extends Packet {
	final static byte SINGLE_STEP_ID = 0x13;
	private Step step;
	
	public Packet13SingleStep() {
		super(SINGLE_STEP_ID);
	}

	public Packet13SingleStep(Step s) {
		super(SINGLE_STEP_ID);
		setStep(s);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeBodyToStream(StreamWriter writer)
			throws StreamWriteException {
		//writer.wri

	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

}
