package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketParser;

/**
 * This converts messages into packets and sends them to the distributors
 *
 * @author Devil Boy (Kervin Sam)
 * 
 * @category Dependency Inversion Principle
 */
public abstract class JMSServerMessageListener implements MessageListener {
	
	private JMSStreamReader reader;
	
	public JMSServerMessageListener(JMSStreamReader reader) {
		this.reader = reader;
	}

	@Override
	public void onMessage(Message message) {
		if (message instanceof StreamMessage) {
			try {
				// Set the reader to read from this message
				reader.setMessage((StreamMessage) message);
				
				// Parse the packet
				Packet packet = CoreBeans.getContext().getBean(PacketParser.class).parsePacket(reader);
				packet.setCorrelationID(message.getJMSCorrelationID());
				
				// Do the reception
				packetReceived(packet, message.getJMSReplyTo());
			} catch (Exception e) {
				// TODO: Handle failure
			}
		} else {
			// TODO: Handle the receiving of the wrong type of message
		}
	}
	
	public abstract void packetReceived(Packet packet, Destination from);
}
