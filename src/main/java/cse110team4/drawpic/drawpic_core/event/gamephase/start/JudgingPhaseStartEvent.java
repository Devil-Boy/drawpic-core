package cse110team4.drawpic.drawpic_core.event.gamephase.start;

import cse110team4.drawpic.drawpic_core.event.Event;
import cse110team4.drawpic.drawpic_core.event.listener.PhaseStartListener;

/**
 * This event is called whenever the judging phase of the game session starts
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class JudgingPhaseStartEvent implements Event<PhaseStartListener> {
	
	public JudgingPhaseStartEvent() {
	}

	@Override
	public void notify(final PhaseStartListener listener) {
		listener.judgingPhaseStart(this);
	}
}
