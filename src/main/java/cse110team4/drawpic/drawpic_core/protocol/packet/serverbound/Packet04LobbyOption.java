package cse110team4.drawpic.drawpic_core.protocol.packet.serverbound;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriteException;
import cse110team4.drawpic.drawpic_core.protocol.StreamWriter;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This packet is sent to the server to indicate what the user chose in relation to lobbies
 * 
 * @author Devil Boy (Kervin Sam)
 *
 */
public class Packet04LobbyOption extends Packet {
	final static byte LOGIN_ID = 0x04;
	
	/**
	 * This enum merely represents the selected option
	 * 
	 * @author Devil Boy (Kervin Sam)
	 *
	 */
	public enum Option { 
		CREATE,
		JOIN
	}
	
	private Option option;

	/**
	 * Constructor that doesn't set any initial values
	 */
	public Packet04LobbyOption() {
		super(LOGIN_ID);
	}

	/**
	 * Constructs the packet with the given option
	 * @param option
	 */
	public Packet04LobbyOption(Option option) {
		this();
		
		this.option = option;
	}
	
	@Override
	public void writeBodyToStream(StreamWriter writer) throws StreamWriteException {
		// Write the option ID
		writer.writeString(option.name());
	}

	@Override
	public void readFromStream(StreamReader reader) throws StreamReadException {
		option = Option.valueOf(reader.readString());
	}
}
