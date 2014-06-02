package cse110team4.drawpic.drawpic_core.lobby;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;

/**
 * This is in charge of parsing lobby settings from the stream reader
 *
 * @author Devil Boy (Kervin Sam)
 *
 * @category Single Responsibility Principle
 */
public class LobbySettingsParser {

	/**
	 * Obtains a LobbySettings object from the given reader
	 * @param reader The reader to use
	 * @return A subclass of ILobbySettings depending on what was in the stream
	 * @throws StreamReadException if there was a read error
	 */
	public static LobbySettings fromStream(StreamReader reader) throws StreamReadException {
		// Get the class name
		String type = reader.readString();
		
		LobbySettings settings = null;
		try {
			settings = CoreBeans.getContext().getBean("empty" + type, LobbySettings.class);
			settings.readFromStream(reader);
		} catch (Exception e) {
			// TODO: Handle lobby settings bean not found
			e.printStackTrace();
		}
		
		return settings;
	}
}
