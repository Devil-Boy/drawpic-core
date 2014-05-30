package cse110team4.drawpic.drawpic_core;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

/**
 * This represents the settings for the four player DrawPic game
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class DrawLobbySettings extends LobbySettings {

	/**
	 * These are the posible methods of choosing round judges
	 *
	 * @author Devil Boy (Kervin Sam)
	 *
	 */
	public enum JudgeSetting {
		RANDOM,
		HOST_ONLY,
		IN_ORDER;
	}
	
	private JudgeSetting judging;
	private int rounds;
	private int maxWins;
	private int drawTime;
	
	/**
	 * Constructs a new DrawLobbySettings object with default settings
	 */
	public DrawLobbySettings() {
		// Set defaults
		judging = JudgeSetting.RANDOM;
		rounds = 3;
		maxWins = 3;
		drawTime = 60;
	}
	
	/**
	 * Sets the method of choosing the judge for each round
	 * @param judging The judge-choosing method
	 */
	public void setJudging(JudgeSetting judging) {
		this.judging = judging;
	}
	
	/**
	 * Gets the method of choosing the judge for each round
	 * @return The judge-choosing method
	 */
	public JudgeSetting getJudging() {
		return judging;
	}
	
	/**
	 * Sets the number of rounds that the game should go for
	 * @param rounds The number of rounds
	 */
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
	/**
	 * Gets the number of rounds that the game will go for
	 * @return The number of rounds
	 */
	public int getRounds() {
		return rounds;
	}
	
	/**
	 * Sets the maximum number of wins for one player before the game ends
	 * @param maxWins The maximum number of wins
	 */
	public void setMaxWins(int maxWins) {
		this.maxWins = maxWins;
	}
	
	/**
	 * Gets the maximum number of wins that will cause the game to end
	 * @return The maximum number of wins
	 */
	public int getMaxWins() {
		return maxWins;
	}
	
	/**
	 * Sets the amount of time (in seconds) that players will be given to make their drawings
	 * @param drawTime The amount of drawing time
	 */
	public void setDrawTime(int drawTime) {
		this.drawTime = drawTime;
	}
	
	/**
	 * Gets the amount of time (in seconds) that players will be given to make their drawings
	 * @return The amount of drawing time
	 */
	public int getDrawTime() {
		return drawTime;
	}
	
	@Override
	public void writeSettingsToStream(StreamWriter writer) throws StreamWriteException {
		// Write the data
		writer.writeString(judging.name());
		writer.writeInt(rounds);
		writer.writeInt(maxWins);
		writer.writeInt(drawTime);
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		judging = JudgeSetting.valueOf(reader.readString());
		rounds = reader.readInt();
		maxWins = reader.readInt();
		drawTime = reader.readInt();
	}
}
