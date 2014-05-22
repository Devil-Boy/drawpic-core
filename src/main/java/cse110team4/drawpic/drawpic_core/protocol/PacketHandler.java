package cse110team4.drawpic.drawpic_core.protocol;

import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/*
 * This handles what to do when a packet is received
 * It can trigger events, change object states, modify data, etc.
 */
public interface PacketHandler {

	void handlePacket(Packet packet);
}
