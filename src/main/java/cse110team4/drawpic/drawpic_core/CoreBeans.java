package cse110team4.drawpic.drawpic_core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreBeans {
	
	public static final String BEANS_CONFIG = "spring/core/beans.xml";

	private static ApplicationContext context = new ClassPathXmlApplicationContext(BEANS_CONFIG);
	
	public static ApplicationContext getContext() {
		return context;
	}
}
