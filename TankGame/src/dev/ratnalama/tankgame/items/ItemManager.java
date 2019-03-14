/**
 * Item.java	--A program responsible to manage reward items lying in the game world.
 * @author        Ratna Lama
 * @version       1.0
 * @since         11/10/2018
 */

package dev.ratnalama.tankgame.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.ratnalama.tankgame.Handler;

public class ItemManager {

	private Handler handler;
	private ArrayList<Item> items;
	
	// Constructor
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	} // end Constructor
	
	// update
	public void tick() {
		Iterator<Item> itr = items.iterator();
		while (itr.hasNext()) {
			Item i = itr.next();
			i.tick();
			
			if (i.isPickedUp()) {
				itr.remove();
			}
		} // end while loop		
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
		for (Item i : items) {
			i.render(magicalBrush);
		}		
	} // end render()
	
	// add item
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	} // end addItem()
	
	/* -------------------------BEGIN Getters and Setters-------------------------------- */ 
	public Handler getHandler() {
		return handler;
	}
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	/* -------------------------END Getters and Setters---------------------------------- */ 
} // end ItemManager Class
