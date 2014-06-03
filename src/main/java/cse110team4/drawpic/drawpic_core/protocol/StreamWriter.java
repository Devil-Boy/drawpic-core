package cse110team4.drawpic.drawpic_core.protocol;

/**
 * Subclasses of this interface can write primitive data to a stream
 * It is based on classes found in StreamMessage and DataOutputStream
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface  StreamWriter {

	/**
	 * Writes a boolean to the stream
	 * @param value The boolean to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeBoolean(boolean value) throws StreamWriteException;
	
	/**
	 * Writes a byte to the stream
	 * @param value The byte to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeByte(byte value) throws StreamWriteException;
	
	/**
	 * Writes an array of bytes to the stream
	 * @param value The bytes to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeBytes(byte[] value) throws StreamWriteException;
	
	
	/**
	 * Writes a char to the stream
	 * @param value The char to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeChar(char value) throws StreamWriteException;
	
	
	/**
	 * Writes a double to the stream
	 * @param value The double to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeDouble(double value) throws StreamWriteException;
	
	
	/**
	 * Writes a float to the stream
	 * @param value The float to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeFloat(float value) throws StreamWriteException;
	
	
	/**
	 * Writes an int to the stream
	 * @param value The int to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeInt(int value) throws StreamWriteException;
	
	
	/**
	 * Writes a long to the stream
	 * @param value The long to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeLong(long value) throws StreamWriteException;
	
	
	/**
	 * Writes a short to the stream
	 * @param value The short to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeShort(short value) throws StreamWriteException;
	
	
	/**
	 * Writes a String to the stream
	 * @param value The String to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeString(String value) throws StreamWriteException;
	
	/**
	 * Write an array of Strings to the stream
	 * @param value The Strings to write
	 * @throws StreamWriteException if there was a write error
	 */
	public void writeStrings(String[] value) throws StreamWriteException;
}
