/**
 * Entity.java		--A program responsible to represent the various entities of the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package dev.ratnalama.tankgame.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.ratnalama.tankgame.Handler;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 3;
	protected Handler handler;
	protected float x, y;
	protected int width, height;	// size of the entity
	protected int health;
	protected boolean active = true;
	
	protected Rectangle bounds;
	
	// Constructor
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
		bounds = new Rectangle(0, 0, width, height); // bounding box to detect collision
	} // end Constructor
	
	public abstract void tick();
	
	public abstract void render(Graphics magicalBrush);
	
	public abstract void expired();	// check if entity is alive or expired
	
	// hurt
	public void hurt(int amt) {
		health -= amt;
		
		if(health <= 0) {
			active = false; 
			expired();	
		}
	} // end hurt()
	
	// check entity collision
	public boolean checkEntityCollision(float xOffset, float yOffset) {
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			
			// if we are checking collision with the object itself then continue
			if (e.equals(this)) {
				continue;
			}
			
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	} // end checkEntityCollision()
	
	// entity collision boundary
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset),
				(int)(y + bounds.y + yOffset),
				bounds.width, bounds.height);
	} // end getCollisionBounds()
	
	
	/* -----------------BEGIN Getters and Setters--------------------------------- */ 
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	/* -----------------END Getters and Setters----------------------------------- */

} // end Entity Class
