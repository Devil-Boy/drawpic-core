package cse110team4.drawpic.drawpic_core.network;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketHandler;

/**
 * This handles the receiving of packets through JMS
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class JMSPacketReceiver implements PacketReceiver, MessageListener {
	
	private Session session;
	private Destination receiveFrom;
	private MessageConsumer receiver;
	
	private PacketHandler handler;

	/**
	 * Creates a new instance of this class that receives messages from the specified destination
	 * @param session The session to receive messages from
	 * @param receiveFrom The destination to receive message from
	 * @throws JMSException if there is an error in initialization
	 */
	public JMSPacketReceiver(Session session, Destination receiveFrom) throws JMSException {
		this.session = session;
		this.receiveFrom = receiveFrom;
		
		receiver = session.createConsumer(receiveFrom);
		receiver.setMessageListener(this);
	}

	/**
	 * Sets the packet handler for this receiver
	 * @param handler The packet handler to use
	 */
	@Override
	public void setPacketHandler(PacketHandler handler) {
		this.handler = handler;
	}

	/**
	 * Gets the packet handler this receiver is routing packets to
	 * @return The PacketHandler set to thie receiver or null if there isn't one
	 */
	@Override
	public PacketHandler getPacketHandler() {
		return handler;
	}

	/**
	 * This method is to be called by the JMS provider
	 * It converts received messages into packets and then sends them to the handler
	 * It will be called asynchronously
	 * @param message The received message
	 */
	@Override
	public void onMessage(Message message) {
		if (handler != null) {
			if (message instanceof StreamMessage) {
				try {
					Packet receivedPacket = Packet.readFromMessage((StreamMessage)message);
					handler.handlePacket(receivedPacket);
				} catch (JMSException e) {
					// Something messed up
					e.printStackTrace();
				}
			} else {
				// We aren't supposed to receive any other type of message
			}
		}
	}
}
