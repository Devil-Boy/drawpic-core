package cse110team4.drawpic.drawpic_core.drawing;

import java.util.LinkedList;
import java.util.List;

public class Canvas {

	private List<Step> steps;
	
	public Canvas() {
		steps = new LinkedList<Step>();
	}
	
	public void addStep(Step step) {
		steps.add(step);
	}
	
	public List<Step> getSteps() {
		return steps;
	}
}
