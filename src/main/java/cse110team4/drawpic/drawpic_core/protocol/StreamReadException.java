package cse110team4.drawpic.drawpic_core.protocol;

public class StreamReadException extends Exception {
	private static final long serialVersionUID = 7599980441599075890L;

	/**
	 * Constructs this exception with a given cause
	 * @param cause The throwable that caused this exception
	 */
	public StreamReadException(Throwable cause) {
		super(cause);
	}
}
