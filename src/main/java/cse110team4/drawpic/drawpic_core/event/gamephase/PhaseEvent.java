package cse110team4.drawpic.drawpic_core.event.gamephase;

import cse110team4.drawpic.drawpic_core.event.Event;
import cse110team4.drawpic.drawpic_core.event.listener.PhaseListener;
import cse110team4.drawpic.drawpic_core.gamesession.GamePhase;

/**
 * This represents an event relating to game phases
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public abstract class PhaseEvent implements Event<PhaseListener> {

	GamePhase phase;
	
	public PhaseEvent(GamePhase phase) {
		this.phase = phase;
	}
	
	/**
	 * Gets the phase involved in this event
	 * @return A game phase
	 */
	public GamePhase getPhase() {
		return phase;
	}
}
