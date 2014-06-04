package cse110team4.drawpic.drawpic_core.player;

import static org.junit.Assert.*;
import org.junit.Test;

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
        assertEquals("", 5, lob.getRounds());
       
        lob.setMaxWins(0);
        assertEquals("", 3, lob.getMaxWins());
       
        lob.setDrawTime(0);
        assertEquals("", 30, lob.getDrawTime());
	}
}
