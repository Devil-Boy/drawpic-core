package cse110team4.drawpic.drawpic_core.event.gamephase.end;

import cse110team4.drawpic.drawpic_core.event.Event;
import cse110team4.drawpic.drawpic_core.event.listener.PhaseEndListener;

/**
 * This event is called whenever the drawing phase of a game session ends
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class DrawingPhaseEndEvent implements Event<PhaseEndListener> {
	
	public DrawingPhaseEndEvent() {
	}

	@Override
	public void notify(final PhaseEndListener listener) {
		listener.drawingPhaseEnd(this);
	}
}
