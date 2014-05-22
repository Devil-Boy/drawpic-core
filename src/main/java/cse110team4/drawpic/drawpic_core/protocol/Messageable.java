package cse110team4.drawpic.drawpic_core.protocol;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

/**
 * This represents an object that can be sent by JMS
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface Messageable {

	/**
	 * Writes this object to the given message
	 * @param message The message to write to
	 * @throws JMSException if there was a write failure
	 */
	void writeToMessage(StreamMessage message) throws JMSException;
}
