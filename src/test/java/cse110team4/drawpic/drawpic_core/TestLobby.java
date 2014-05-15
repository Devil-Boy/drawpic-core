package cse110team4.drawpic.drawpic_core;

import static org.junit.Assert.*;

import org.junit.Test;

import cse110team4.drawpic.drawpic_core.DrawLobby;

public class TestLobby {

	@Test
	public void testMaxPlayers() {
		DrawLobby lob = new DrawLobby("Bob");
		assertEquals(4, lob.maxPlayers());
	}

}
