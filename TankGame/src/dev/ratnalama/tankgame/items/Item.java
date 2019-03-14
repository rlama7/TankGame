/**
 * Item.java	--A program responsible to represent reward items.
 * @author        Ratna Lama
 * @version       1.0
 * @since         11/10/2018
 */

package dev.ratnalama.tankgame.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.graphics.Assets;

public class Item {

	// Handler
	public static Item[] items = new Item[256];
	public static Item rewardItem01 = new Item(Assets.rewardItem01, "RewardItem01", 0);
	public static Item gravelWall = new Item(Assets.gravelWall, "GravelWall", 1);
	
	// CLASS
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	protected Rectangle bounds;	
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	// Constructor
	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		items[id] = this;		
	} // end Constructor
	
	// update
	public void tick() {
		// player #1
		if (handler.getWorld().getEntityManager().getPlayer1().getCollisionBounds(0f, 0f).intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer1().getInventory().addItem(this);
		}
		
		// player #2
		if (handler.getWorld().getEntityManager().getPlayer2().getCollisionBounds(0f, 0f).intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer2().getInventory().addItem(this);
		}	
	} // end tick()
	
	
	// render method renders items lying in the game world
	public void render(Graphics magicalBrush) {
		if (handler == null) {
			return;
		}
		
		// delegate the overridden render()
		render(magicalBrush, 
				(int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset())); 
		
	} // end render()
	
	// Overridden render method renders items in player's inventory
	public void render(Graphics magicalBrush, int x, int y) {
		magicalBrush.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);		
	} // end render()
	
	
	/* ----------------------BEGIN Utility Methods------------------------------------------------- */
	// for testing purposes
	public Item createNewItem(int count) {
		Item i = new Item(texture, name, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	public Item createNewItem(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	} // end createNewItem()
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	} // end setPosition()
	/* ----------------------END Utility Methods--------------------------------------------------- */
	
	/* ----------------------BEGIN Getters and Setters---------------------------------------------- */
	public Handler getHandler() {
		return handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCount() {
		return count;
	}
	
	public boolean isPickedUp() {
		return pickedUp;
	}
	
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setCount(int count) {
		this.count = count;
	}	
	/* ----------------------END Getters and Setters------------------------------------------------ */
	
} // end Item Class
