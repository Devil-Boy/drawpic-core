package cse110team4.drawpic.drawpic_core.protocol;

public class StreamWriteException extends Exception {
	private static final long serialVersionUID = -4685505175951441471L;

	/**
	 * Constructs this exception with a given cause
	 * @param cause The throwable that caused this exception
	 */
	public StreamWriteException(Throwable cause) {
		super(cause);
	}
}
