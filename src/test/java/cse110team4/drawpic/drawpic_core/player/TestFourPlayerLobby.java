package cse110team4.drawpic.drawpic_core.player;

import static org.junit.Assert.*;

import org.junit.Test;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.player.FourPlayerLobby;

public class TestFourPlayerLobby {
/*
	@Test
	public void testMaxPlayers() {
		FourPlayerLobby lob = CoreBeans.getContext().getBean("defaultFourPlayerLobby", FourPlayerLobby.class); // TODO: Pass a mock or something
		lob.setHost("Bob");
		
		assertEquals(4, lob.maxPlayers());
	}
	
	@Test
	public void testAddPlayers(){
		FourPlayerLobby lob = CoreBeans.getContext().getBean("defaultFourPlayerLobby", FourPlayerLobby.class); // TODO: Pass a mock or something
		lob.setHost("Bob");
		
		assertTrue(lob.addPlayer("Frank"));
		assertTrue(lob.addPlayer("Sinatra"));
		assertFalse(lob.addPlayer("Frank")); //Test for adding the same name
		assertTrue(lob.addPlayer("Bert"));
		assertFalse(lob.addPlayer("Cap")); //Test for adding too many players
		assertFalse(lob.addPlayer("Siren")); //Another test for adding too many players
	}
	
	@Test
	public void testNumOfPLayers(){
		FourPlayerLobby lob = CoreBeans.getContext().getBean("defaultFourPlayerLobby", FourPlayerLobby.class); // TODO: Pass a mock or something
		lob.setHost("Bob");
		
		assertEquals(1, lob.numOfPlayers());
		lob.addPlayer("Frank");
		assertEquals(2, lob.numOfPlayers());
		lob.addPlayer("Sinatra");
		assertEquals(3, lob.numOfPlayers());
		lob.addPlayer("Bert");
		assertEquals(4, lob.numOfPlayers());
	}
	
	@Test
	public void testGetPlayers(){
		FourPlayerLobby lob = CoreBeans.getContext().getBean("defaultFourPlayerLobby", FourPlayerLobby.class); // TODO: Pass a mock or something
		lob.setHost("Bob");
		
		lob.addPlayer("Frank");
		lob.addPlayer("Sinatra");
		lob.addPlayer("Bert");
		assertEquals(4, lob.getPlayers().length);
		assertEquals("Bob", lob.getPlayers()[0]);
		assertEquals("Frank", lob.getPlayers()[1]);
		assertEquals("Sinatra", lob.getPlayers()[2]);
		assertEquals("Bert", lob.getPlayers()[3]);
	}
	
	@Test
	public void testRemovePlayer(){
		FourPlayerLobby lob = CoreBeans.getContext().getBean("defaultFourPlayerLobby", FourPlayerLobby.class); // TODO: Pass a mock or something
		lob.setHost("Bob");
		
		lob.addPlayer("Frank");
		lob.addPlayer("Sinatra");
		lob.addPlayer("Bert");
		assertFalse(lob.removePlayer("Bob")); //Test removing host
		assertTrue(lob.removePlayer("Frank"));
		assertFalse(lob.removePlayer("Frank")); //Test for removing a player twice
	}
	
	@Test
	public void testGetHost(){
		FourPlayerLobby lob = CoreBeans.getContext().getBean("defaultFourPlayerLobby", FourPlayerLobby.class); // TODO: Pass a mock or something
		lob.setHost("Bob");
		
		assertEquals("Bob",lob.getHost()); //Initial check
		lob.addPlayer("Frank");
		assertEquals("Bob",lob.getHost()); //checking after adding 1 player
		lob.addPlayer("Sinatra");
		assertEquals("Bob",lob.getHost());
		lob.addPlayer("Bert");
		assertEquals("Bob",lob.getHost());
	}
*/
}
