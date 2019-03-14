/**
 * UIManager.java		--A program to represent the user interface manager class.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  11/04/2018
 */

package dev.ratnalama.tankgame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import dev.ratnalama.tankgame.Handler;

public class UIManager {

	private Handler handler;
	private ArrayList<UIObject> objects;
	
	// Constructor
	public UIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIObject>();		
	} // end Constructor
	
	// update
	public void tick() {
		for (UIObject o : objects) {
			o.tick();			
		}
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
		for (UIObject o : objects) {
			o.render(magicalBrush);			
		}		
	} // end render()
	
	/* ------------------------------------BEGIN Mouse Event------------------------- */
	public void onMouseMove(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseMove(e);			
		}	
	}
	
	public void onMouseRelease(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseRelease(e);			
		}		
	}
	/* ------------------------------------END Mouse Event--------------------------- */
	
	/* ---------------------------------ADD/REMOVE UIObject------------------------- */
	
	public void addObject(UIObject o) {
		objects.add(o);		
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
	}
	
	/* ----------------------BEGIN Getters and Setters------------------------------ */
	public Handler getHandler() {
		return handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}
	/* ----------------------END Getters and Setters-------------------------------- */
	
} // end UIManager Class
