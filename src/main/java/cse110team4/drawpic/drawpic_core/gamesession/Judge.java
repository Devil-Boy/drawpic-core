package cse110team4.drawpic.drawpic_core.gamesession;

/**
 * This represents a judge of a game round
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class Judge {

	/**
	 * This is the artist number of the chosen winner
	 * It should be 0 when no decision has yet been made or 1-3 if one has been made
	 */
	private int decision;

	/**
	 * Constructor
	 */
	public Judge() {
		this.decision = 0;
	}

	/**
	 * @return decision which should be an int
	 */
	public int getDecision() {
		return decision;
	}


}
