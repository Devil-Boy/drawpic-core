package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.JMSException;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;

public class JMSStreamReader extends JMSStreamHandler implements StreamReader {
	
	/**
	 * Constructs this without an initial message to read from
	 */
	public JMSStreamReader() {
		super();
	}

	@Override
	public boolean readBoolean() throws StreamReadException {
		try {
			return message.readBoolean();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public byte readByte() throws StreamReadException {
		try {
			return message.readByte();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public void readBytes(byte[] buffer) throws StreamReadException {
		try {
			message.readBytes(buffer);
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public char readChar() throws StreamReadException {
		try {
			return message.readChar();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public double readDouble() throws StreamReadException {
		try {
			return message.readDouble();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public float readFloat() throws StreamReadException {
		try {
			return message.readFloat();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public int readInt() throws StreamReadException {
		try {
			return message.readInt();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public long readLong() throws StreamReadException {
		try {
			return message.readLong();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public short readShort() throws StreamReadException {
		try {
			return message.readShort();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public String readString() throws StreamReadException {
		try {
			return message.readString();
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

	@Override
	public void readStrings(String[] buffer) throws StreamReadException {
		try {
			for (int i=0; i < buffer.length; i++) {
				buffer[i] = message.readString();
			}
		} catch (JMSException e) {
			throw new StreamReadException(e);
		}
	}

}
