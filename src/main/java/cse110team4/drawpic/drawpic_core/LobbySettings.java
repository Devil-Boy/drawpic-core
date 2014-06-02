package cse110team4.drawpic.drawpic_core;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.Streamable;

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
		writer.writeString(this.getClass().getSimpleName());
		
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
