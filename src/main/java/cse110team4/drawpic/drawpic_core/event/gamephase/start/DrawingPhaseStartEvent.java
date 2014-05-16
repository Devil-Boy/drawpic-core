package cse110team4.drawpic.drawpic_core.event.gamephase.start;

import cse110team4.drawpic.drawpic_core.event.Event;
import cse110team4.drawpic.drawpic_core.event.listener.PhaseStartListener;

/**
 * This event is called whenever the drawing phase of a game session starts
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class DrawingPhaseStartEvent implements Event<PhaseStartListener> {
	
	public DrawingPhaseStartEvent() {
	}

	@Override
	public void notify(final PhaseStartListener listener) {
		listener.drawingPhaseStart(this);
	}
}
