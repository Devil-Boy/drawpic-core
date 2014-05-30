package cse110team4.drawpic.drawpic_core;

import java.util.ArrayList;
import java.util.List;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;

/**
 * This class represents a lobby for the draw game with a max of 4 players
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class DrawLobby extends Lobby {
	static final int MAX_PLAYERS = 4;
	
	/**
	 * This is the list of players in the lobby
	 * The lobby host must be at index 0
	 */
	private List<String> players;

	/**
	 * Constructs a new lobby with the given host
	 * @param host The host's username
	 */
	public DrawLobby(String host) {
		super(host, new DrawLobbySettings());
		
		players = new ArrayList<String>(MAX_PLAYERS);
		players.add(host);
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
			if (!username.equals(getHost())) {
				players.remove(username);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void writeLobbyToStream(StreamWriter writer) throws StreamWriteException {
		// Write player list to the stream
		writer.writeStrings(getPlayers());
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		String[] receivedPlayers = new String[4];
		reader.readStrings(receivedPlayers);
		
		players = new ArrayList<String>(MAX_PLAYERS);
		for (int i=0; i < receivedPlayers.length; i++) {
			players.set(i, receivedPlayers[i]);
		}
	}
}
