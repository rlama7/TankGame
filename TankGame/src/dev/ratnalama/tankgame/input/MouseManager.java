/**
 * MouseManager.java	--A program responsible to manage the mouse input.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  11/04/2018
 */

package dev.ratnalama.tankgame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.ratnalama.tankgame.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	
	// UIManager
	private UIManager uiManager;
	
	// Constructor
	public MouseManager() {
		
	} // end Constructor
		

	/* ------------------------BEGIN Override Methods---------------------------------------------------- */
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) { // BUTTON1 == left button
			leftPressed = true;
		} else if (e.getButton() == MouseEvent.BUTTON3) { // BUTTON3 == right button
			rightPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) { // BUTTON1 == left button
			leftPressed = false;
		} else if (e.getButton() == MouseEvent.BUTTON3) { // BUTTON3 == right button
			rightPressed = false;
		}
		
		if (uiManager != null) {
			uiManager.onMouseRelease(e);			
		}		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if (uiManager != null) {
			uiManager.onMouseMove(e);			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
				
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
				
	}

	@Override
	public void mouseExited(MouseEvent e) {
				
	}
	/* ------------------------END Override Methods-------------------------------------------------- */
	
	/* -------------------------BEGIN Getters and Setters------------------------------------------- */
	public boolean isLeftPressed() {
		return leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	/* -------------------------END Getters and Setters------------------------------------------ */
	
} // end MouseManager Class
