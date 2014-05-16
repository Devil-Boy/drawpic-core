package cse110team4.drawpic.drawpic_core.event.listener;

import cse110team4.drawpic.drawpic_core.event.gamephase.start.DrawingPhaseStartEvent;
import cse110team4.drawpic.drawpic_core.event.gamephase.start.JudgingPhaseStartEvent;
import cse110team4.drawpic.drawpic_core.event.gamephase.start.ResultsPhaseStartEvent;

/**
 * This is an interface that allows for listening to phase endings
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface PhaseStartListener {

	public void drawingPhaseStart(DrawingPhaseStartEvent event);
	
	public void judgingPhaseStart(JudgingPhaseStartEvent event);
	
	public void resultsPhaseStart(ResultsPhaseStartEvent event);
}
