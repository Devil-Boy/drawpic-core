package cse110team4.drawpic.drawpic_core.protocol.packet.bidirectional;

import cse110team4.drawpic.drawpic_core.player.LobbySettings;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * Packet to send the lobby settings to the server
 * @author Kirk
 *
 */
public class Packet0ELobbySettings extends Packet {

	final static byte LOBBY_SETTINGS = 0x0E;
	private LobbySettings settings;
	
	/**
	 * Default constructor
	 */
	public Packet0ELobbySettings() {
		super(LOBBY_SETTINGS);
	}
	
	public LobbySettings getSetting() {
		return settings;
	}

	/**
	 * Constructor to store settings
	 * @param settings to pass in Lobbysettings to be sent
	 */
	public Packet0ELobbySettings(LobbySettings settings){
		super(LOBBY_SETTINGS);
		this.settings = settings;
	}
	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		// Not needed

	}

	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		settings.writeToStream(writer);

	}

}
