package cse110team4.drawpic.drawpic_core.protocol.packet;



/**
 * This interface will receive packets and route them to the packet handler
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface PacketReceiver {

	/**
	 * Sets the packet handler that this receiver will send packets to
	 * @param handler The packet handler to send packets to
	 */
	public void setPacketHandler(PacketHandler handler);
	
	/**
	 * Gets the packet handler that is currently set
	 * @return The PacketHandler that is handling received packets, null if none set
	 */
	public PacketHandler getPacketHandler();
}
