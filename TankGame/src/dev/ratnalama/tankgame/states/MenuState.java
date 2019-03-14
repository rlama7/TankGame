/**
 * MenuState.java	--A program responsible to represent the menu state of the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package dev.ratnalama.tankgame.states;

import java.awt.Graphics;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.graphics.Assets;
import dev.ratnalama.tankgame.ui.ClickListener;
import dev.ratnalama.tankgame.ui.UIManager;
import dev.ratnalama.tankgame.ui.UImageButton;

public class MenuState extends State {
	
	// UIManager
	private UIManager uiManager;
	
	// Constructor 
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UImageButton(250, 250, 128, 128, Assets.startButton, new ClickListener(){
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null); // unset uiManger when the game state changes
				State.setState(handler.getGame().getGameState());				
			}
		}));
		
	} // end Constructor

	@Override
	public void tick() {
		// UIManager
		uiManager.tick();		
	} // end tick()

	@Override
	public void render(Graphics magicalBrush) {
		// UIManager
		uiManager.render(magicalBrush);
	} // end render()

} // end MenuState Class
