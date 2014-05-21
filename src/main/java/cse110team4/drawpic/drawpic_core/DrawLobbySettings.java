package cse110team4.drawpic.drawpic_core;

public class DrawLobbySettings implements LobbySettings {

	public enum JudgeSetting {
		RANDOM,
		HOST_ONLY,
		IN_ORDER;
	}
	
	private JudgeSetting judging;
	private int rounds;
	private int maxWins;
	private int drawTime;
	
	public DrawLobbySettings() {
		// Set defaults
		judging = JudgeSetting.RANDOM;
		rounds = 3;
		maxWins = 3;
		drawTime = 60;
	}
	
	public void setJudging(JudgeSetting judging) {
		this.judging = judging;
	}
	
	public JudgeSetting getJudging() {
		return judging;
	}
}
