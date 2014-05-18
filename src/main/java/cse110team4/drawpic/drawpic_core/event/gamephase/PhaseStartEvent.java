package cse110team4.drawpic.drawpic_core.event.gamephase;

import cse110team4.drawpic.drawpic_core.event.listener.PhaseListener;
import cse110team4.drawpic.drawpic_core.gamesession.GamePhase;

/**
 * This event is called whenever a phase starts
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class PhaseStartEvent extends PhaseEvent {

	public PhaseStartEvent(GamePhase phase) {
		super(phase);
	}

	@Override
	public void notify(PhaseListener listener) {
		listener.phaseStart(this);
	}

}
