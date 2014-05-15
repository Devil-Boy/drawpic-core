package cse110team4.drawpic.drawpic_core.event;

public interface Event<L> {

	public void notify(final L listener);
}
