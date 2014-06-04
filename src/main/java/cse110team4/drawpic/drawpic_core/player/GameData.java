package cse110team4.drawpic.drawpic_core.player;

import cse110team4.drawpic.drawpic_core.gamesession.GamePhase;

public class GameData {

	private GamePhase phase;
	private String judge;
	
	public GamePhase getPhase() {
		return phase;
	}
	
	public void setPhase(GamePhase phase) {
		this.phase = phase;
	}
	
	public String getJudge() {
		return judge;
	}
	
	public void setJudge(String judge) {
		this.judge = judge;
	}
}
