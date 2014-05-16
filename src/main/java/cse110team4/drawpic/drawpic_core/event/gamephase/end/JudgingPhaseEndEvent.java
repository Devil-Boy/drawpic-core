package cse110team4.drawpic.drawpic_core.event.gamephase.end;

import cse110team4.drawpic.drawpic_core.event.Event;
import cse110team4.drawpic.drawpic_core.event.listener.PhaseEndListener;

/**
 * This event is called whenever the judging phase of the game session ends
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class JudgingPhaseEndEvent implements Event<PhaseEndListener> {
	
	public JudgingPhaseEndEvent() {
	}

	@Override
	public void notify(final PhaseEndListener listener) {
		listener.judgingPhaseEnd(this);
	}
}
