package cse110team4.drawpic.drawpic_core.protocol;

import java.util.Random;

/**
 * This class merely created random correlation IDs
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class CorrelationIDGenerator {

	private Random random;
	
	/**
	 * Constructs a new instance of this class using the given random generator
	 * @param random The random generator to use
	 */
	public CorrelationIDGenerator(Random random) {
		this.random = random;
	}
	
	/**
	 * Generated a new random correlation ID
	 * @return A String correlation ID based off of a random long
	 */
	public String randomCorrelationID() {
		return Long.toHexString(random.nextLong());
	}
}
