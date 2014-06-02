package cse110team4.drawpic.drawpic_core.lobby;

import cse110team4.drawpic.drawpic_core.CoreBeans;
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
}
