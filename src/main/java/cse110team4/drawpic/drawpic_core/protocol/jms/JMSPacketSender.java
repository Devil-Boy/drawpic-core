package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketSender;

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
	
	private JMSStreamWriter writer;
	
	/**
	 * Creates a new instance of this class that will send messages to the given destination
	 * @param session The session to send messages through
	 * @param sendTo Where to send messages to
	 * @throws JMSException if there is an issue with initialization
	 */
	public JMSPacketSender(Session session, Destination sendTo) throws JMSException {
		this.session = session;
		this.sendTo = sendTo;
		
		// Create the message writer
		writer = new JMSStreamWriter();
		
		// Prepare the message sender
		sender = session.createProducer(sendTo);
	}

	@Override
	public void sendPacket(Packet packet) throws Exception {
		// Create a new message
		StreamMessage message = session.createStreamMessage();
		
		// Set the writer to write to the message
		writer.setMessage(message);
		
		// Write the packet
		packet.writeToStream(writer);
		
		// Add a destination for replies
		message.setJMSReplyTo(replyTo);
		
		// Set the correlation ID
		if (packet.getCorrelationID() != null) {
			message.setJMSCorrelationID(packet.getCorrelationID());
		}
		
		// Send the packet off
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
