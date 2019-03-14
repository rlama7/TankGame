/**
 * Bullet.java	--A program responsible to represent a bullet - a collide-able entity.
 * @author        Ratna Lama
 * @version       1.0
 * @since         11/11/2018
 */

package dev.ratnalama.tankgame.entity.collidable;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ratnalama.tankgame.graphics.Assets;

public class Bullet {

	private double x, y;
	
	BufferedImage image;	
	
	// Constructor 
	public Bullet(double x, double y) {
		this.x = x;
		this.y = y;
		 
	} // end Constructor
	
	// update
	public void tick() {
		x += 3;
		y = 300;	
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
		magicalBrush.drawImage(Assets.leftBullet, (int) x, (int) y, null);
		
	} // end render()
	
	// Getters and Setters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}	

} // end Bullet Class
