package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.JMSException;
import org.apache.activemq.ActiveMQConnection;


/**
 * Given class that cleans up when the client closes
 * @author Prof Mennerini
 *
 */
public class JMSCloseHook extends Thread {
	ActiveMQConnection connection;
	private JMSCloseHook(ActiveMQConnection connection) {
		this.connection = connection;
	}
	
	public static Thread registerCloseHook(ActiveMQConnection connection) {
		Thread ret = new JMSCloseHook(connection);
		Runtime.getRuntime().addShutdownHook(ret);
		return ret;
	}
	
	public void run() {
		try {
			System.out.println("Closing ActiveMQ connection");
			connection.close();
		} catch (JMSException e) {
			/* 
			 * This means that the connection was already closed or got 
			 * some error while closing. Given that we are closing the
			 * client we can safely ignore this.
			*/
		}
	}
}
