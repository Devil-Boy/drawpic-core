package cse110team4.drawpic.drawpic_core.protocol;

import java.util.Random;

/**
 * This class merely created random correlation IDs
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class CorrelationIDFactory {
	
	private static CorrelationIDFactory singleton = new CorrelationIDFactory();

	private Random random;
	
	/**
	 * Constructs a new instance of this class
	 */
	public CorrelationIDFactory() {
		random = new Random();
	}
	
	/**
	 * Generated a new random correlation ID
	 * @return A String correlation ID based off of a random long
	 */
	public String randomCorrelationID() {
		return Long.toHexString(random.nextLong());
	}
	
	/**
	 * Gets the singleton of this class
	 * @return A CorrelationIDFactory instance
	 */
	public static CorrelationIDFactory getFactory() {
		return singleton;
	}
}
