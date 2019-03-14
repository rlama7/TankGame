/**
e * KeyManager.java	--A program responsible to manage user inputs.
 * @author            Ratna Lama
 * @version           1.0
 * @since             10/27/2018
 */

package dev.ratnalama.tankgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right;  // player movement
	public boolean bullet, bulletUp, bulletDown, bulletRight, bulletLeft; // bullet displacement
	
	
	// Constructor
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];		
	} // end Constructor
	
	public void tick() {
		for (int i = 0; i < keys.length; i++) {
			if (cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			} else if (justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			
			if (!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		} // end for-loop
				
		// player movement
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		// bullet displacement
		//bullet = keys[KeyEvent.VK_B];
		bulletUp = keys[KeyEvent.VK_W];
		bulletDown = keys[KeyEvent.VK_S];
		bulletRight = keys[KeyEvent.VK_D];
		bulletLeft = keys[KeyEvent.VK_A];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// check if the key code is beyond the acceptable limit
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = true;
		//System.out.println("Pressed!");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// check if the key code is beyond the acceptable limit
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
		
	}
	
	public boolean keyJustPressed(int keyCode) {
		// check if the key code is beyond the acceptable limit
		if (keyCode < 0 || keyCode >= keys.length) {
			return false;
		}
		return justPressed[keyCode];
	}
 
} // end KeyManager Class
