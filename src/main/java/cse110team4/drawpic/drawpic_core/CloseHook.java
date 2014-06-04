package cse110team4.drawpic.drawpic_core;

import java.util.ArrayList;
import java.util.List;


/**
 * Given class that cleans up when the programs closes
 * @author Prof Mennerini
 *
 */
public class CloseHook extends Thread {
	private List<Runnable> hooks;
	
	public CloseHook() {
		hooks = new ArrayList<Runnable>();
		
		Runtime.getRuntime().addShutdownHook(this);
	}
	
	public void addHook(Runnable hook) {
		hooks.add(hook);
	}
	
	public void run() {
		for (Runnable hook : hooks) {
			hook.run();
		}
	}
}
