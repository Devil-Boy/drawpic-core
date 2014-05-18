package cse110team4.drawpic.drawpic_core.event.gamephase;

import cse110team4.drawpic.drawpic_core.event.listener.PhaseListener;
import cse110team4.drawpic.drawpic_core.gamesession.GamePhase;

/**
 * This event is called whenever a phase ends
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PhaseEndEvent extends PhaseEvent {

	public PhaseEndEvent(GamePhase phase) {
		super(phase);
	}

	@Override
	public void notify(PhaseListener listener) {
		listener.phaseEnd(this);
	}

}
