package cse110team4.drawpic.drawpic_core.player;

/**
 * This stores some data about a client
 *
 * @author Devil Boy (Kervin Sam)
 *
 * @category Liskov Substitution Principle
 */
public class ClientData {

	private String username;
	private Lobby lobby;
	
	/**
	 * Gets the username of this client
	 * @return The String username that was logged in with, null if login has never completed
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the stored username
	 * Does not cause synchronization and cannot be used to change username
	 * @param username The username to set this to
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the lobby this client is in
	 * @return The Lobby object this client is in, null if not in a lobby
	 */
	public Lobby getLobby() {
		return lobby;
	}
	
	/**
	 * Sets the stored lobby
	 * Does not cause synchronization and cannot be used to change the lobby the client it in
	 * @param lobby The Lobby to set this to
	 */
	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}
}
