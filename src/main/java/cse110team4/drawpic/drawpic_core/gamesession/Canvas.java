package cse110team4.drawpic.drawpic_core.gamesession;

import cse110team4.drawpic.drawpic_core.protocol.*;

import java.util.List;
import java.util.ArrayList;

public class Canvas implements Streamable {
	/**
	 * width of the frame
	 */
	private int width;

	/**
	 * height of the frame
	 */
	private int height;

	/**
	 * the canvas, 1D arrayList that stores all drawing on screen.
	 * TODO: INTEGER TYPE WILL BE LATER CHANGED TO A BLOT TYPE
	 */
	List<Integer> canvas;


	public Canvas(int x, int y) {
		this.width = x;
		this.height = y;
		canvas = new ArrayList<>();
	}

	/**
	 * stores a "blot"
	 * @param x x coord of draw
	 * @param y y coord of draw
	 * TODO: INTEGER WILL BE LATER CHANGED TO A BLOT TYPE
	 */
	public void draw(Integer x) {
		canvas.add(x);
	}

	/**
	 * erases a "blot"
	 * @param x
	 * @param y
	 */
	public void erase(Integer x) {
		if(!(canvas.get(x) == null)) {
			canvas.remove(x);
		}
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	/**
	 * Writes this object to the a stream
	 *
	 * @param write The writer to use
	 * @throws cse110team4.drawpic.drawpic_core.protocol.StreamWriteException
	 *          if there was a write failure
	 */
	@Override
	public void writeToStream( StreamWriter writer ) throws StreamWriteException {
		//TODO: INTEGER WILL BE REPLACED WITH BLOT
		for(Integer i : canvas) {
			//write each blot to stream
		}
	}

	/**
	 * Restores this object's fields by reading from a stream
	 *
	 * @param reader The reader to use
	 * @throws cse110team4.drawpic.drawpic_core.protocol.StreamReadException
	 *          if there was a read error
	 */
	@Override
	public void readFromStream( StreamReader reader ) throws StreamReadException {
		//only writes to stream, don't need this.
	}
}
