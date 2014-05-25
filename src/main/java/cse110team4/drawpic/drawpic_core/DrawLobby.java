package cse110team4.drawpic.drawpic_core;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a lobby for the draw game with a max of 4 players
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class DrawLobby implements Lobby {
	static final int MAX_PLAYERS = 4;
	
	/**
	 * This is the list of players in the lobby
	 * The lobby host must be at index 0
	 */
	private List<String> players;
	
	/**
	 * This stores the settings for this lobby
	 */
	private DrawLobbySettings settings;

	/**
	 * Constructs a new lobby with the given host
	 * @param host The host's username
	 */
	public DrawLobby(String host) {
		players = new ArrayList<String>(MAX_PLAYERS);
		players.add(host);
		
		settings = new DrawLobbySettings();
	}
	
	/**
	 * The max for this lobby is 4
	 * @return The integer 4
	 */
	@Override
	public int maxPlayers() {
		return MAX_PLAYERS;
	}
	
	@Override
	public int numOfPlayers() {
		return players.size();
	}
	
	@Override
	public boolean addPlayer(String username) {
		// Check if lobby is full
		if (players.size() < MAX_PLAYERS) {
			// Check if the user is already in the lobby
			if (!players.contains(username)) {
				players.add(username);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String getHost() {
		return players.get(0);
	}
	
	/**
	 * Gets the players in this lobby
	 * @return A 4-element array containing either player names or null for missing players
	 */
	@Override
	public String[] getPlayers() {
		return players.toArray(new String[MAX_PLAYERS]);
	}

	@Override
	public boolean removePlayer(String username) {
		// Check that the specified player is in the lobby
		if (players.contains(username)) {
			// Make sure they aren't removing the host
			if (!username.equals(players.get(0))) {
				players.remove(username);
				return true;
			}
		}
		return false;
	}

	@Override
	public DrawLobbySettings getSettings() {
		return settings;
	}
}
