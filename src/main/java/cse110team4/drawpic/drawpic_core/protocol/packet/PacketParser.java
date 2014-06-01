package cse110team4.drawpic.drawpic_core.protocol.packet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;

/**
 * This is in charge of parsing packets from the stream reader
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PacketParser {
	
	private static ApplicationContext packetBeans = new ClassPathXmlApplicationContext("spring/core/packets.xml");

	public static Packet parsePacket(StreamReader reader) throws StreamReadException {
		// Get the packet's id
		byte id = reader.readByte();
		
		Packet packet = null;
		try {
			packet = packetBeans.getBean("emptyPacket" + idToHexString(id), Packet.class);
			packet.readFromStream(reader);
		} catch (Exception e) {
			// TODO: Handle bean not being found
		}
		
		return packet;
	}
	
	public static String idToHexString(byte id) {
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
