package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.StreamMessage;

public abstract class JMSStreamHandler {

	protected StreamMessage message;
	
	/**
	 * Constructs this without an initial message
	 */
	public JMSStreamHandler() {
	}
	
	/**
	 * Constructs this with an initial message
	 * @param message The message to write to
	 */
	public JMSStreamHandler(StreamMessage message) {
		this.message = message;
	}
	
	/**
	 * Sets the message that this will work upon
	 * @param message The message to work with
	 */
	public void setMessage(StreamMessage message) {
		this.message = message;
	}
	
	/**
	 * Gets the message that is currently being worked upon
	 * @return The currently set message or null if there isn't one
	 */
	public StreamMessage getMessage() {
		return message;
	}
}
