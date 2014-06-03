package cse110team4.drawpic.drawpic_core.protocol.jms;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.CoreBeans;
import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.packet.Packet;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketHandler;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketParser;
import cse110team4.drawpic.drawpic_core.protocol.packet.PacketReceiver;

/**
 * This handles the receiving of packets through JMS
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class JMSPacketReceiver implements PacketReceiver, MessageListener {
	
	private JMSStreamReader reader;
	private List<PacketHandler> handlers;

	/**
	 * Creates a new instance of this class
	 */
	public JMSPacketReceiver(JMSStreamReader reader, List<PacketHandler> handlers) {
		this.reader = reader;
		this.handlers = handlers;
	}
	
	@Override
	public void addPacketHandler(PacketHandler handler) {
		if (!handlers.contains(handler)) {
			handlers.add(handler);
		}
	}

	@Override
	public void removePacketHandler(PacketHandler handler) {
		handlers.remove(handler);
	}

	@Override
	public List<PacketHandler> getPacketHandlers() {
		return handlers;
	}

	/**
	 * This method is to be called by the JMS provider
	 * It converts received messages into packets and then sends them to the handler
	 * It will be called asynchronously
	 * @param message The received message
	 */
	@Override
	public void onMessage(Message message) {
		if (message instanceof StreamMessage) {
			try {
				// Set the reader to read from this message
				reader.setMessage((StreamMessage) message);
				
				// Parse the packet
				Packet packet = CoreBeans.getContext().getBean(PacketParser.class).parsePacket(reader);
				
				// Set the packet correlation ID if there was a JMS one
				try {
					packet.setCorrelationID(message.getJMSCorrelationID());
				} catch (JMSException e) {
					// Something happened while trying to get the correlation ID
					e.printStackTrace();
				}
				
				// Send the packet to the handlers
				for (PacketHandler handler : handlers) {
					handler.handlePacket(packet);
				}
			} catch (StreamReadException e) {
				// TODO: Handle a parse/read failure
				e.printStackTrace();
			}
		} else {
			// We aren't supposed to receive any other type of message
			// TODO: Handle the receiving of the wrong type of message
		}
	}
}
