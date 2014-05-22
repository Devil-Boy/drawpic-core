package cse110team4.drawpic.drawpic_core.protocol;

import javax.jms.StreamMessage;

/**
 * This represents a message to be sent over the network
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public abstract class Packet implements Messageable {
	private byte id;
	
	public Packet(byte id) {
		this.id = id;
	}
	
	public byte getID() {
		return id;
	}
	
	/*
	public static Packet readFromMessage(StreamMessage message) {
		
	}*/
}
