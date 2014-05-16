package cse110team4.drawpic.drawpic_core.event.listener;

import cse110team4.drawpic.drawpic_core.event.lobby.PlayerJoinedLobbyEvent;
import cse110team4.drawpic.drawpic_core.event.lobby.PlayerLeftLobbyEvent;

public interface LobbyListener {

	public void playerJoinedLobby(PlayerJoinedLobbyEvent event);
	
	public void playerLeftLobby(PlayerLeftLobbyEvent event);
}
