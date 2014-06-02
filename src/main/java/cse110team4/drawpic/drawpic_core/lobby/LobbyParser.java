package cse110team4.drawpic.drawpic_core.lobby;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;

/**
 * This is in charge of parsing lobbies from the stream reader
 *
 * @author Devil Boy (Kervin Sam)
 *
 *@category Single Responsibility Principle
 */
public class LobbyParser {

	/**
	 * Obtains a Lobby object from the given reader
	 * @param reader The reader to use
	 * @return A subclass of ILobby depending on what was in the stream
	 * @throws StreamReadException if there a read error
	 */
	public Lobby fromStream(StreamReader reader) throws StreamReadException {
		// Get class name
		String type = reader.readString();
		
		Lobby lobby = null;
		try {
			lobby = CoreBeans.getContext().getBean("empty" + type, Lobby.class);
			lobby.readFromStream(reader);
		} catch (Exception e) {
			// TODO: Handle lobby bean not found
			e.printStackTrace();
		}
		
		return lobby;
	}
}
