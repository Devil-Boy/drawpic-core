package cse110team4.drawpic.drawpic_core.event.listener;

import cse110team4.drawpic.drawpic_core.event.gamephase.PhaseEndEvent;
import cse110team4.drawpic.drawpic_core.event.gamephase.PhaseStartEvent;

/**
 * This is an interface that allows for listening to phase endings
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface PhaseListener {

	public void phaseStart(PhaseStartEvent event);
	
	public void phaseEnd(PhaseEndEvent event);
}
