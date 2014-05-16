package cse110team4.drawpic.drawpic_core.event.gamephase.start;

import cse110team4.drawpic.drawpic_core.event.Event;
import cse110team4.drawpic.drawpic_core.event.listener.PhaseStartListener;

/**
 * This event is called whenever the results-showing phase of a game starts
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public class ResultsPhaseStartEvent implements Event<PhaseStartListener> {

	public ResultsPhaseStartEvent() {
	}

	@Override
	public void notify(final PhaseStartListener listener) {
		listener.resultsPhaseStart(this);
	}
}
