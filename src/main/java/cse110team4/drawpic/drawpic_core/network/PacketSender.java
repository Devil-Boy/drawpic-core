package cse110team4.drawpic.drawpic_core.network;

import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This interface will handle sending packets to the server
 * 
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface PacketSender {

	/**
	 * Sends a packet to the server
	 * @param packet The packet to send
	 * @throws Exception if there was an issue sending the packet
	 */
	public void sendPacket(Packet packet) throws Exception;
}
