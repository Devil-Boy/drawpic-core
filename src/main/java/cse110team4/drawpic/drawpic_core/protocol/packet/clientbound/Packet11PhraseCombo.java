package cse110team4.drawpic.drawpic_core.protocol.packet.clientbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

public class Packet11PhraseCombo extends Packet {
	final static byte PHRASE_COMBO_ID = 0x11;
	
	private String phrase;

	public Packet11PhraseCombo() {
		super(PHRASE_COMBO_ID);
	}
	
	public Packet11PhraseCombo(String p) {
		super(PHRASE_COMBO_ID);
		setPhrase(p);
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		phrase = reader.readString();
	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		writer.writeString(phrase);
	}


}
