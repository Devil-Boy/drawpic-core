package cse110team4.drawpic.drawpic_core.player;

import static org.junit.Assert.*;

import org.junit.Test;

import cse110team4.drawpic.drawpic_core.player.NormalLobbySettings.JudgeSetting;

public class TestNormalLobbySettings {
	@Test
	public void testIntegers() {
		NormalLobbySettings lob = new NormalLobbySettings();
        
        lob.setRounds(5);
        assertEquals("", 5, lob.getRounds());
       
        lob.setMaxWins(5);
        assertEquals("", 5, lob.getMaxWins());
       
        lob.setDrawTime(5);
        assertEquals("", 5, lob.getDrawTime());
       
        lob.setRounds(0);
        assertEquals("", 0, lob.getRounds());
       
        lob.setMaxWins(0);
        assertEquals("", 0, lob.getMaxWins());
       
        lob.setDrawTime(0);
        assertEquals("", 0, lob.getDrawTime());
	}
	
	@Test
	public void testJudge() {
		NormalLobbySettings lob = new NormalLobbySettings();
		
		if(lob.getJudging() == null) {
			//pass
		} else {
			fail();
		}
		
		lob.setJudging(JudgeSetting.HOST_ONLY);
		
		assertEquals("", JudgeSetting.HOST_ONLY, lob.getJudging());
	}
}
