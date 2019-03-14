/**
 * BulletController.java	--A program responsible to represent a bullet controller class.
 * @author        			  Ratna Lama
 * @version       			  1.0
 * @since         			  11/11/2018
 */

package dev.ratnalama.tankgame.entity.collidable;

import java.awt.Graphics;
import java.util.LinkedList;

import dev.ratnalama.tankgame.Handler;

public class BulletController {
	
	private Handler handler;
	private LinkedList<Bullet> bullet;
	Bullet tempBullet;
	
	// Constructor
	public BulletController(Handler handler) {
		this.handler = handler;
		bullet = new LinkedList<Bullet>();
		addBullet(new Bullet(700, 700));
	} // end BulletController()
	
	
	// update
	public void tick() {
		for (int i = 0; i < bullet.size(); i++) {
			tempBullet = bullet.get(i);
			
			// remove bullet if it goes beyond Y-axis
			if (tempBullet.getY() < 0) {
				removeBullet(tempBullet);
			}
			tempBullet.tick();
		}		
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
		for (int i = 0; i < bullet.size(); i++) {
			tempBullet = bullet.get(i);
			tempBullet.render(magicalBrush);
		}		
	} // end render()
	
	// add bullet
	public void addBullet(Bullet magazine) {
		bullet.add(magazine);
	} // end addBullet()
	
	
	// remove bullet
	public void removeBullet(Bullet magazine) {
		bullet.remove(magazine);		
	} // end removeBullet()
	
	/* ------------------------BEGIN Getters and Setters---------------------- */ 
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	/* ------------------------END Getters and Setters------------------------ */ 

} // end BulletController Class
