package cse110team4.drawpic.drawpic_core.gamesession;

/**
 * This represents an artist for a game round
 *
 * @author Devil Boy (Kervin Sam)
 * @author Cinnamon Bagels (Sam Ko)
 *
 */
public class Artist {
	
	/**
	 * This is the number of this artist
	 * It will be a number 1-3
	 */
	private int playerNumber;

	/**
	 * Artist's drawing color
	 */
	private String color;

	/**
	 * This is the artist's drawing canvas
	 */
	Canvas canvas;

	/**
	 * Constructor
	 * @param playerNumber the player number
	 */
	public Artist(int playerNumber) {
		this.playerNumber = playerNumber;
		this.canvas = new Canvas(400, 400);
		this.color = "black";
	}

	/**
	 * sets the players color to the desired color
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the player id
	 */
	public int getPlayerID() {
		return playerNumber;
	}

	/**
	 *
	 * @return the player color
	 */
	public String getColor() {
		return color;
	}

	public void drawBlot(int x, int y) {

	}
}
