package cse110team4.drawpic.drawpic_core.protocol.jms;

import java.util.Map;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketDistributor;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketParser;

/**
 * This converts messages into packets and sends them to the distributors
 *
 * @author Devil Boy (Kervin Sam)
 * 
 * @category Dependency Inversion Principle
 */
public class JMSMessageListener implements MessageListener {
	
	private JMSStreamReader reader;
	
	private PacketDistributor globalDistributor;
	private Map<Destination, PacketDistributor> singleDistributors;
	
	public JMSMessageListener(JMSStreamReader reader, Map<Destination, PacketDistributor> singleDistributors) {
		this.reader = reader;
		this.singleDistributors = singleDistributors;
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
				
				// Send to global
				if (globalDistributor != null) {
					globalDistributor.distributePacket(packet);
				}
				
				// Send to singles
				PacketDistributor singleDistributor = singleDistributors.get(message.getJMSReplyTo());
				if (singleDistributor != null) {
					singleDistributor.distributePacket(packet);
				}
			} catch (Exception e) {
				// TODO: Handle failure
			}
		} else {
			// TODO: Handle the receiving of the wrong type of message
		}
	}
	
	public PacketDistributor getGlobalDistributor() {
		return globalDistributor;
	}

	public void setGlobalDistributor(PacketDistributor globalDistributor) {
		this.globalDistributor = globalDistributor;
	}
}
