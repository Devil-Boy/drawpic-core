package cse110team4.drawpic.drawpic_core.protocol;

/**
 * This represents an object that can be sent through a stream
 * This is based on Java's Serializable interface
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface Streamable {

	/**
	 * Writes this object to the a stream
	 * @param write The writer to use
	 * @throws StreamWriteException if there was a write failure
	 */
	public void writeToStream(StreamWriter writer) throws StreamWriteException;
	
	/**
	 * Restores this object's fields by reading from a stream
	 * @param reader The reader to use
	 * @throws StreamReadException if there was a read error
	 */
	public void readFromStream(StreamReader reader) throws StreamReadException;
}
