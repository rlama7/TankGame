/**
 * Rocket.java	--A program responsible to represent a rocket - a static entity.
 * @author        Ratna Lama
 * @version       1.0
 * @since         11/10/2018
 */

package dev.ratnalama.tankgame.entity.statics;

import java.awt.Graphics;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.graphics.Assets;
import dev.ratnalama.tankgame.items.Item;
import dev.ratnalama.tankgame.tile.Tile;

public class Rocket extends StaticEntity {

	// Constructor
	public Rocket(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		
		// set boundary for rocket entity
		bounds.x = 6;
		bounds.y = 6;// 
		bounds.width = width-10;
		bounds.height = height-20;
	} // end Constructor

	@Override
	public void tick() {
		
	} // end tick()
	
	@Override
	public void expired() {
		handler.getWorld().getItemManager().addItem(Item.rewardItem01.createNewItem((int) x, (int) y));
		
	} // expired()

	@Override
	public void render(Graphics magicalBrush) {
	
		magicalBrush.drawImage(Assets.rocket02, 
				(int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), 
				width, height, null);
		
	} // end render()

} // end Rocket Class
