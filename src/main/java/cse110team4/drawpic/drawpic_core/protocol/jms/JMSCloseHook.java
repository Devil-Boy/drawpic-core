package cse110team4.drawpic.drawpic_core.protocol.jms;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnection;

import cse110team4.drawpic.drawpic_core.CoreBeans;


/**
 * Given class that cleans up when the client closes
 * @author Prof Mennerini
 *
 */
public class JMSCloseHook implements Runnable {
	
	public void run() {
		try {
			System.out.println("Closing ActiveMQ connection");
			CoreBeans.getContext().getBean("activeMQConnection", ActiveMQConnection.class).close();
		} catch (JMSException e) {
			/* 
			 * This means that the connection was already closed or got 
			 * some error while closing. Given that we are closing the
			 * client we can safely ignore this.
			*/
		}
	}
}
