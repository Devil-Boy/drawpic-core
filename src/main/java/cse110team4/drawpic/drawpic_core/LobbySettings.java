package cse110team4.drawpic.drawpic_core;

import cse110team4.drawpic.drawpic_core.protocol.*;

/**
 * This represents the settings for a game lobby
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public abstract class LobbySettings implements Streamable {

	@Override
	public void writeToStream(StreamWriter writer) throws StreamWriteException {
		// Write the class name
		writer.writeString(this.getClass().getName());
		
		// Write the settings
		writeSettingsToStream(writer);
	}
	
	/**
	 * Write the settings using the given writer
	 * @param writer The writer to use
	 * @throws StreamWriteException if there was a write error
	 */
	public abstract void writeSettingsToStream(StreamWriter writer) throws StreamWriteException;
	
	/**
	 * Obtains a LobbySettings object from the given reader
	 * @param reader The reader to use
	 * @return A subclass of LobbySettings depending on what was in the stream
	 * @throws StreamReadException if there was a read error
	 */
	public static LobbySettings fromStream(StreamReader reader) throws StreamReadException {
		// Get the class name
		String type = reader.readString();
		
		LobbySettings settings = null;
		if (type.equals(DrawLobbySettings.class.getName())) {
			settings = new DrawLobbySettings();
		}
		
		if (settings == null) {
			// TODO: Handle unknown settings type
		} else {
			settings.readFromStream(reader);
		}
		
		return settings;
	}
}
