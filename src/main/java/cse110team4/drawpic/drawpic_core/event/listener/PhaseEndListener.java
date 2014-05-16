package cse110team4.drawpic.drawpic_core.event.listener;

import cse110team4.drawpic.drawpic_core.event.gamephase.end.DrawingPhaseEndEvent;
import cse110team4.drawpic.drawpic_core.event.gamephase.end.JudgingPhaseEndEvent;
import cse110team4.drawpic.drawpic_core.event.gamephase.end.ResultsPhaseEndEvent;

/**
 * This is an interface that allows for listening to phase endings
 *
 * @author Devil Boy (Kervin Sam)
 *
 */
public interface PhaseEndListener {

	public void drawingPhaseEnd(DrawingPhaseEndEvent event);
	
	public void judgingPhaseEnd(JudgingPhaseEndEvent event);
	
	public void resultsPhaseEnd(ResultsPhaseEndEvent event);
}
