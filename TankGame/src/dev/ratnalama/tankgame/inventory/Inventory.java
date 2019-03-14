/**
 * Inventory.java	--A program responsible to represent item inventory class.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/14/2018
 */

package dev.ratnalama.tankgame.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.entity.creature.Player;
import dev.ratnalama.tankgame.graphics.Assets;
import dev.ratnalama.tankgame.graphics.Text;
import dev.ratnalama.tankgame.items.Item;

public class Inventory {
	
	private Handler handler;
	private Player player;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 32, invY = 32,
			invWidth = 200, invHeight = 200,
			invListCenterX = invX, //+ 171,
			invListCenterY = invY; //+ (invHeight / 2 + 5);
	
	// Constructor
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
		// test
		addItem(Item.rewardItem01.createNewItem(5));
		
		
	} // end Constructor
	
	// update
	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_M)) {
			active = !active;
		}
		
		if (!active) {
			return;
		}
		
		// INVENTORY TEST
		System.out.println("INVENTORY: ");
		for (Item i : inventoryItems) {
			System.out.println(i.getName() + " " + i.getCount());
		}		
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
		if (!active) {
			return;
		}
		
		// inventory screen
		magicalBrush.drawImage(Assets.inventoryScreen, invX, invY+530, invWidth, invHeight-100, null);
		magicalBrush.drawImage(Assets.inventoryScreen, invX+1100, invY+530, invWidth, invHeight-100, null);
		
		// text on screen
		// Player 01
		Text.drawString(magicalBrush, "Player #1 ", invListCenterX+50, 
				invListCenterY + 540, true, Color.WHITE, Assets.font12);
		Text.drawString(magicalBrush, "Health >", invListCenterX+50, 
				invListCenterY + 560, true, Color.WHITE, Assets.font12);
		Text.drawString(magicalBrush, "Ammo >", invListCenterX+50, 
				invListCenterY + 580, true, Color.WHITE, Assets.font12);
		for (Item i : inventoryItems) {
			System.out.println(i.getName() + " " + i.getCount());
		}
		
		// Player 02
		Text.drawString(magicalBrush, "Player #2 ", invListCenterX+1150, 
				invListCenterY + 540, true, Color.BLUE, Assets.font12);
		Text.drawString(magicalBrush, "Health >", invListCenterX+1150, 
				invListCenterY + 560, true, Color.BLUE, Assets.font12);
		Text.drawString(magicalBrush, "Ammo >", invListCenterX+1150, 
				invListCenterY + 580, true, Color.BLUE, Assets.font12);
		
	} // render()
	
	/* ----------------------BEGIN Utility Methods------------------------------ */
	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);		
	} // end addItem()	
	/* ----------------------END Utility Methods-------------------------------- */
	
	
	/* ----------------------BEGIN Getters and Setters------------------------- */
	public Handler getHandler() {
		return handler;
	}

	public boolean isActive() {
		return active;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	/* ----------------------END Getters and Setters--------------------------- */
} // end Inventory Class
