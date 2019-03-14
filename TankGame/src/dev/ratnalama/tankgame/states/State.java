/**
 * State.java		--A program responsible to represent the various states of the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package dev.ratnalama.tankgame.states;

import java.awt.Graphics;
import dev.ratnalama.tankgame.Handler;

public abstract class State { 
	
	
	private static State currentState = null;
	
	// Setter
	public static void setState(State state) {
		currentState = state;		
	} // end setState()
	
	// Getter
	public static State getState() {
		return currentState;
	} // end getState()
	
	// CLASS
	protected Handler handler;
	
	// Constructor
	public State(Handler handler) {
		this.handler = handler;
		
	} // end Constructor
	
	public abstract void tick();
	
	public abstract void render(Graphics magicalBrush);

} // end State Class
