package cse110team4.drawpic.drawpic_core.protocol;

/**
 * Subclasses of this interface can read primitive data from a stream
 * It is based on classes found in StreamMessage and DatainputStream
 *
 * @author Devil Boy (Kervin Sam)
 *
 * @category Strategy Pattern
 */
public interface StreamReader {

	/**
	 * Reads a boolean from the stream
	 * @return The read boolean
	 * @throws StreamReadException if there was a read error
	 */
	public boolean readBoolean() throws StreamReadException;
	
	/**
	 * Reads a byte from the stream
	 * @return The read byte
	 * @throws StreamReadException if there was a read error
	 */
	public byte readByte() throws StreamReadException;
	
	/**
	 * Reads an array of bytes from the stream into the given buffer
	 * @param buffer The buffer to read into
	 * @throws StreamReadException if there was a read error
	 */
	public void readBytes(byte[] buffer) throws StreamReadException;
	
	
	/**
	 * Reads a char from the stream
	 * @return The read char
	 * @throws StreamReadException if there was a read error
	 */
	public char readChar() throws StreamReadException;
	
	
	/**
	 * Reads a double from the stream
	 * @return The read double
	 * @throws StreamReadException if there was a read error
	 */
	public double readDouble() throws StreamReadException;
	
	
	/**
	 * Reads a float from the stream
	 * @return The read float
	 * @throws StreamReadException if there was a read error
	 */
	public float readFloat() throws StreamReadException;
	
	
	/**
	 * Reads an int from the stream
	 * @return The read int
	 * @throws StreamReadException if there was a read error
	 */
	public int readInt() throws StreamReadException;
	
	
	/**
	 * Reads a long from the stream
	 * @return The read long
	 * @throws StreamReadException if there was a read error
	 */
	public long readLong() throws StreamReadException;
	
	
	/**
	 * Reads a short from the stream
	 * @return The read short
	 * @throws StreamReadException if there was a read error
	 */
	public short readShort() throws StreamReadException;
	
	
	/**
	 * Reads a String from the stream
	 * @return The read String
	 * @throws StreamReadException if there was a read error
	 */
	public String readString() throws StreamReadException;
	
	/**
	 * Reads an array of Strings from the stream into the given buffer
	 * @param buffer The buffer to read into
	 * @throws StreamReadException if there was a read error
	 */
	public void readStrings(String[] buffer) throws StreamReadException;
}
