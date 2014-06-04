package cse110team4.drawpic.drawpic_core.player;

import static org.junit.Assert.*;

import org.junit.Test;

import cse110team4.drawpic.drawpic_core.gamesession.GamePhase;

public class TestGameData {
	@Test
	public void testGameData() {
		GameData data = new GameData();
		
		if(data.getPhase() == null) {
			//pass
		} else {
			fail();
		}
		
		if(data.getJudge() == null) {
			//pass	
		} else {
			fail();
		}
		
		data.setPhase(GamePhase.DRAW_PHASE);
		
		assertEquals("", GamePhase.DRAW_PHASE, data.getPhase());
		
		data.setJudge("huehue");
		
		assertEquals("","huehue", data.getJudge());
		
		
	}

}
