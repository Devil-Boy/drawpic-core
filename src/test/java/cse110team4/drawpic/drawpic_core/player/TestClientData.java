package cse110team4.drawpic.drawpic_core.player;

import static org.junit.Assert.*;
import org.junit.Test;

import cse110team4.drawpic.drawpic_core.CoreBeans;

/**
 * Fully tests the funcationality for class ClientData.java
 * @author Sam Ko
 *
 */

public class TestClientData {
	@Test
	public void testUsername() {
		ClientData data = CoreBeans.getContext().getBean("clientData", ClientData.class);
		
		if(data.getUsername() == null) {
			//pass
		} else {
			fail();
		}
		
		data.setUsername("huehue");
		assertEquals("testing equals", "huehue", data.getUsername());
	}
	
	@Test
	public void testClientLobby() {
		ClientData data = CoreBeans.getContext().getBean("clientData", ClientData.class);
		
		if(data.getLobby() == null) {
			//pass
		} else {
			fail();
		}
		
		FourPlayerLobby lob = CoreBeans.getContext().getBean("defaultFourPlayerLobby", FourPlayerLobby.class);
		lob.setHost("huehue");
		
		data.setLobby(lob);
		
		assertEquals("testing equals", lob, data.getLobby());
	}
}
