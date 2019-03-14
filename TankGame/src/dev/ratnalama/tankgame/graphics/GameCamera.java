/**
 * GameCamera.java	--A program responsible to represent the game camera.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/02/2018
 */

package dev.ratnalama.tankgame.graphics;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.entity.Entity;
import dev.ratnalama.tankgame.tile.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	
	// Constructor
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
	} // end Constructor
	
	// Check BlankSpace
	public void checkBlankSpace() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEWIDTH - handler.getHeight();
		}
	} // end checkBlankSpace()
	
	public void centerEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
		checkBlankSpace();
 	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	

	/* ---------------------BEGIN Getters and Setters----------------------------------- */
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	/* ---------------------END Getters and Setters------------------------------------- */

} // end GameCamera Class
