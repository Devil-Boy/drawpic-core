package cse110team4.drawpic.drawpic_core.protocol.packet;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;

/**
 * This is in charge of parsing packets from the stream reader
 *
 * @author Devil Boy (Kervin Sam)
 *
 * @category Single Responsibility Principle
 */
public class PacketParser {
	
	/**
	 * Parses a packet from the given stream reader
	 * @param reader The reader to use
	 * @return A Packet based on the reader's data
	 * @throws StreamReadException if there was a read error
	 */
	public Packet parsePacket(StreamReader reader) throws StreamReadException {
		// Get the packet's id
		byte id = reader.readByte();
		
		Packet packet = null;
		try {
			packet = CoreBeans.getContext().getBean("emptyPacket" + idToHexString(id), Packet.class);
			packet.readFromStream(reader);
		} catch (Exception e) {
			// TODO: Handle packet bean not being found
			e.printStackTrace();
		}
		
		return packet;
	}
	
	/**
	 * Utility method to convert bytes to hexadecimal Strings and not lose leading zeros
	 * @param id The byte to convert
	 * @return A String representing a byte in hexadecimal form
	 */
	public String idToHexString(byte id) {
		StringBuilder sb = new StringBuilder();
		String hex = Integer.toHexString(id);
		
		// Add any leading zeros
		if (hex.length() < 2) {
			sb.append('0');
		}
		sb.append(hex);
		
		return sb.toString();
	}
}
