package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.StreamMessage;

import cse110team4.drawpic.drawpic_core.protocol.StreamReadException;
import cse110team4.drawpic.drawpic_core.protocol.StreamReader;
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
	
	private Session session;
	private Destination receiveFrom;
	private MessageConsumer receiver;
	
	private JMSStreamReader reader;
	private PacketParser parser;
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
		
		// Set up packet parsing
		this.reader = new JMSStreamReader();
		this.parser = new PacketParser(this.reader);
		
		// Start receiving messages
		receiver = session.createConsumer(receiveFrom);
		receiver.setMessageListener(this);
	}

	@Override
	public void setPacketHandler(PacketHandler handler) {
		this.handler = handler;
	}

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
					// Set the reader to read from this message
					reader.setMessage((StreamMessage) message);
					
					// Parse the packet and send it to the handler
					handler.handlePacket(parser.parsePacket());
				} catch (StreamReadException e) {
					// TODO: Handler a parse/read failure
					e.printStackTrace();
				}
			} else {
				// We aren't supposed to receive any other type of message
				// TODO: Handle the receiving of the wrong type of message
			}
		}
	}
}
