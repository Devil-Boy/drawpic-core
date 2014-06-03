package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.JMSException;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

public class JMSStreamWriter extends JMSStreamHandler implements StreamWriter {

	/**
	 * Constructs this writer without an initial message to write to
	 */
	public JMSStreamWriter() {
		super();
	}
	
	@Override
	public void writeBoolean(boolean value) throws StreamWriteException {
		try {
			message.writeBoolean(value);
		} catch (JMSException e) {
			throw new StreamWriteException(e);
		}
	}

	@Override
	public void writeByte(byte value) throws StreamWriteException {
		try {
			message.writeByte(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeBytes(byte[] value) throws StreamWriteException {
		try {
			message.writeBytes(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeChar(char value) throws StreamWriteException {
		try {
			message.writeChar(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeDouble(double value) throws StreamWriteException {
		try {
			message.writeDouble(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeFloat(float value) throws StreamWriteException {
		try {
			message.writeFloat(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeInt(int value) throws StreamWriteException {
		try {
			message.writeInt(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeLong(long value) throws StreamWriteException {
		try {
			message.writeLong(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeShort(short value) throws StreamWriteException {
		try {
			message.writeShort(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeString(String value) throws StreamWriteException {
		try {
			message.writeString(value);
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}

	@Override
	public void writeStrings(String[] value) throws StreamWriteException {
		try {
			for (int i=0; i < value.length; i++) {
				message.writeString(value[i]);
			}
		} catch (JMSException e) {
			throw new StreamWriteException (e);
		}
	}
}
