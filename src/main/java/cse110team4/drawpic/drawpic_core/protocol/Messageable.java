package cse110team4.drawpic.drawpic_core.protocol;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

public interface Messageable {

	void writeToMessage(StreamMessage message) throws JMSException;
}
