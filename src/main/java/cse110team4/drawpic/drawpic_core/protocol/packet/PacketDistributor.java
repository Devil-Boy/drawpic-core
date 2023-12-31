package cse110team4.drawpic.drawpic_core.protocol.packet;

import java.util.List;



/**
 * This will receive packets and route them to the packet handlers
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PacketDistributor {
	
	private List<PacketHandler> handlers;
	
	public PacketDistributor(List<PacketHandler> handlers) {
		this.handlers = handlers;
	}

	/**
	 * Adds a packet handler that this receiver will send packets to
	 * @param handler The packet handler to start sending packets to
	 */
	public void addPacketHandler(PacketHandler handler) {
		if (!handlers.contains(handler)) {
			handlers.add(handler);
		}
	}
	
	/**
	 * Remove a packet handler so that it no longer receives packets
	 * @param handler The packet handler to no longer send packets to
	 */
	public void removePacketHandler(PacketHandler handler) {
		handlers.remove(handler);
	}
	
	public void distributePacket(Packet packet) {
		for (PacketHandler handler : handlers) {
			handler.handlePacket(packet);
		}
	}
}
