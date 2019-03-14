/**
 * BreakableWall.java	--A program responsible to represent a breakable wall - a static entity.
 * @author        		  Ratna Lama
 * @version       		  1.0
 * @since         		  11/15/2018
 */

package dev.ratnalama.tankgame.entity.statics;

import java.awt.Graphics;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.graphics.Assets;
import dev.ratnalama.tankgame.items.Item;
import dev.ratnalama.tankgame.tile.Tile;

public class BreakableWall extends StaticEntity{

	// Constructor
	public BreakableWall(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*2);
		
		// set boundary for breakable walls
		bounds.x = 8;
		bounds.y = 8;
		bounds.width = width;
		bounds.height = height;		
	} // end Constructor

	// update
	@Override
	public void tick() {
				
	} // end tick()
	
	// expired
	@Override
	public void expired() {
		handler.getWorld().getItemManager().addItem(Item.rewardItem01.createNewItem((int) x, (int) y));
	} // end expired()
	
	// draw
	@Override
	public void render(Graphics magicalBrush) {
		magicalBrush.drawImage(Assets.gravelWall, 
				(int)(x-handler.getGameCamera().getxOffset()), 
				(int)(y-handler.getGameCamera().getyOffset()),
				width, height, null);		
	} // end render()

} // end BreakableWall Class
