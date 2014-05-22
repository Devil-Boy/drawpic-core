package cse110team4.drawpic.drawpic_core.protocol;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

public class PacketConnect extends Packet {
	final static byte CONNECT_ID = 0x01;
	
	public PacketConnect() {
		super(CONNECT_ID);
	}

	@Override
	public void writeToMessage(StreamMessage message) throws JMSException {
		// First write the packet type
		message.writeByte(getID());
	}
}
