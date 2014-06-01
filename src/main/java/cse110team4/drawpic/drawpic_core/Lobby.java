package cse110team4.drawpic.drawpic_core;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.Streamable;

/**
 * This represents a game lobby that can contain a certain amount of players and has a specified host player
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public abstract class Lobby implements Streamable {
	
	/**
	 * Stores who is hosting the lobby
	 */
	private String host;
	
	/**
	 * This stores the settings for this lobby
	 */
	private LobbySettings settings;
	
	/**
	 * Constructs class with no arg
	 */
	public Lobby(){
	}
	
	/**
	 * Sets the host of this lobby
	 * @return The String username of the lobby host
	 */
	public void setHost(String host) {
		this.host = host;;
	}
	
	/**
	 * Gets the host of this lobby
	 * @return The String username of the lobby host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Gets the settings of this lobby
	 * @return The object storing the lobby settings
	 */
	public void setSettings(LobbySettings settings) {
		this.settings = settings;
	}
	
	/**
	 * Gets the settings of this lobby
	 * @return The object storing the lobby settings
	 */
	public LobbySettings getSettings() {
		return settings;
	}
	
	/**
	 * Gets the maximum amount of players allowed in this lobby
	 * @return An integer
	 */
	public abstract int maxPlayers();
	
	/**
	 * Gets the number of players currently in this lobby
	 * @return An integer representing the number of players
	 */
	public abstract int numOfPlayers();
	
	/**
	 * Attempts to add the specified player to this lobby
	 * @param username The username of the player to add
	 * @return True if the lobby isn't full and the player isn't already in the lobby. False otherwise
	 */
	public abstract boolean addPlayer(String username);
	
	/**
	 * Gets the players in this lobby
	 * @return An array of size equal to the maximum player amount containing either player names or null for missing players
	 */
	public abstract String[] getPlayers();
	
	/**
	 * Attempts to remove a player from this lobby
	 * @param username The username of the player to remove
	 * @return True if the player could be found and the player wasn't the host. False otherwise
	 */
	public abstract boolean removePlayer(String username);
	
	@Override
	public void writeToStream(StreamWriter writer) throws StreamWriteException {
		// Write the lobby class name
		writer.writeString(this.getClass().getName());
		
		// Write the lobby host
		writer.writeString(host);
		
		// Write the lobby settings
		settings.writeToStream(writer);
		
		// Write the lobby data
		writeLobbyToStream(writer);
	}
	
	/**
	 * Write the lobby using the given writer
	 * @param writer The writer to use
	 * @throws StreamWriteException if there was a write error
	 */
	public abstract void writeLobbyToStream(StreamWriter writer) throws StreamWriteException;
	
	/**
	 * Obtains a Lobby object from the given reader
	 * @param reader The reader to use
	 * @return A subclass of Lobby depending on what was in the stream
	 * @throws StreamReadException if there a read error
	 */
	public static Lobby fromStream(StreamReader reader) throws StreamReadException {
		// Get class name
		String type = reader.readString();
		
		Lobby lobby = null;
		if (type.equals(DrawLobby.class.getName())) {
			lobby = new DrawLobby();
		}
		
		if (lobby == null) {
			// TODO: Handle unknown lobby type
		} else {
			lobby.readFromStream(reader);
		}
		
		return lobby;
	}
}
