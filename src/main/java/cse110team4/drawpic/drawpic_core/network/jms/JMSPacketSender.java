package cse110team4.drawpic.drawpic_core.network.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.network.PacketSender;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;

/**
 * This handles the sending of packets through JMS
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class JMSPacketSender implements PacketSender {
	
	private Session session;
	private Destination sendTo;
	private MessageProducer sender;
	private Destination replyTo;
	
	/**
	 * Creates a new instance of this class that will send messages to the given destination
	 * @param session The session to send messages through
	 * @param sendTo Where to send messages to
	 * @throws JMSException if there is an issue with initialization
	 */
	public JMSPacketSender(Session session, Destination sendTo) throws JMSException {
		this.session = session;
		this.sendTo = sendTo;
		
		sender = session.createProducer(sendTo);
	}

	/**
	 * Sends the specified packet
	 * @param packet The packet to send
	 * @throws JMSException if there was a failure to write or send
	 */
	@Override
	public void sendPacket(Packet packet) throws JMSException {
		StreamMessage message = session.createStreamMessage();
		packet.writeToMessage(message);
		message.setJMSReplyTo(replyTo);
		sender.send(message);
	}

	/**
	 * Sets where replies to sent messages should go
	 * @param replyTo The Destination for replies to go to
	 */
	public void setReplyTo(Destination replyTo) {
		this.replyTo = replyTo;
	}

	/**
	 * Gets the destination where replies should go
	 * @return The Destination replies should arrive in, null if replies shouldn't arrive
	 */
	public Destination getReplyTo() {
		return replyTo;
	}
}
