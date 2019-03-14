/**
 * Creature.java	--A program responsible to represent the various creatures with mobility in the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package dev.ratnalama.tankgame.entity.creature;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.entity.Entity;
import dev.ratnalama.tankgame.tile.Tile;

public abstract class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected float speed;
	protected float xMove, yMove;
	
	// Constructor
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	} // end Constructor
	
	public void move() {
		// move in X-axis
		if (!checkEntityCollision(xMove, 0f)) {
			moveX();			
		}
		
		// move in Y-axis
		if (!checkEntityCollision(0f, yMove)) {
			moveY();
		}		
	} // end move()
	
	/* -----------------------------BEGIN COLLISION-------------------------------------------------------- */
	// move to the right: X-axis
	public void moveX() {		
		if (xMove > 0) {	// move right
			int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if (!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && 
				!collisionWithTile(tx, (int)(y + bounds.y + bounds.height)/ Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		} else if (xMove < 0) {	// move left
			int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if (!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;				
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	} // end moveX()
	
	// move to the left: Y-axis
	public void moveY() {
		if (yMove < 0) {	// move up
			int ty = (int)(y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
			
		} else if (yMove > 0) { 	// move down
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height -1;
			}
		}		
	} // end moveY()
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	} // end collisionWithTile()
	
	/* -----------------------------END COLLISION---------------------------------------------------------- */
	

	
	/*------------------------BEGIN Getters and Setters-----------------------------------------------------*/
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}	
	/*------------------------END Getters and Setters-------------------------------------------------------*/

} // end Creature Class
