/**
 * GameState.java	--A program responsible to represent the various states of the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package dev.ratnalama.tankgame.states;

import java.awt.Graphics;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.gameworld.GameWorld;

public class GameState extends State {
	
	private GameWorld world;
	
	// Constructor
	public GameState(Handler handler) {
		super(handler);
		world = new GameWorld(handler, "resources/world/world1.txt");
		handler.setWorld(world);		
	} // end Constructor

	@Override
	public void tick() {
		world.tick();		
	} // end tick()

	@Override
	public void render(Graphics magicalBrush) {
		world.render(magicalBrush);
	} // end render()
} // end GameState Class
