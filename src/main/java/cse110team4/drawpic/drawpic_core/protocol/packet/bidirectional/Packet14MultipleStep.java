package cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional;

import java.util.ArrayList;
import java.util.List;

import cse110team4.drawpic.drawpic_core.drawing.Step;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

public class Packet14MultipleStep extends Packet {
	final static byte MULTIPLE_STEP_ID = 0x14;
	private List<Step> stepList;

	public Packet14MultipleStep() {
		super(MULTIPLE_STEP_ID);
	}
	
	public Packet14MultipleStep(List<Step> list) {
		super(MULTIPLE_STEP_ID);
		stepList = list;
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		this.stepList = new ArrayList<Step>();
		int numSteps = reader.readInt();
		for(int i = 0; i < numSteps; ++i) {
			stepList.add(Step.fromStream(reader));
		}
	}

	@Override
	public void writeBodyToStream(StreamWriter writer)
			throws StreamWriteException {
		writer.writeInt(stepList.size());
		for(Step step : stepList) {
			step.writeStepToStream(writer);
		}
	}

}
