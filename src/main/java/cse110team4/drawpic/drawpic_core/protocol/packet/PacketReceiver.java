package cse110team4.drawpic.drawpic_core.protocol.packet;

import java.util.List;



/**
 * This interface will receive packets and route them to the packet handlers
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface PacketReceiver {

	/**
	 * Adds a packet handler that this receiver will send packets to
	 * @param handler The packet handler to start sending packets to
	 */
	public void addPacketHandler(PacketHandler handler);
	
	/**
	 * Remove a packet handler so that it no longer receives packets
	 * @param handler The packet handler to no longer send packets to
	 */
	public void removePacketHandler(PacketHandler handler);
	
	/**
	 * Gets the list of packet handlers
	 * @return A list containing all the packet handler
	 */
	public List<PacketHandler> getPacketHandlers();
}
