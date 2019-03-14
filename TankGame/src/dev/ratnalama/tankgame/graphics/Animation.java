/**
 * Animation.java	--A program responsible to display animation.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/04/2018
 */

package dev.ratnalama.tankgame.graphics;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	// Constructor
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0; // time counter
		lastTime = System.currentTimeMillis();	// millisecond counter
		
	} // end Constructor
	
	// update
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if (timer > speed) {
			index++;
			timer = 0;
			// loop back to initial frame
			if (index >= frames.length) {
				index = 1;
				//return;
			}
		}		
	} // end tick()
	
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	

} // end Animation Class
