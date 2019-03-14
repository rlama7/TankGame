/**
 * Assets.java		--A program responsible to represent tile.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package dev.ratnalama.tankgame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	// STATIC HERE
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);  // grassTile has id: 0
	public static Tile dirtTile = new DirtTile(1);   // dirtTile has id: 1
	public static Tile rockTile = new RockTile(2);	// rockTile has id: 2
	
	// CLASS
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	// Constructor
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;		
		tiles[id] = this;
	} // end Constructor
	
	// update game
	public void tick() {
		
	}
	
	// draw game
	public void render(Graphics magicalBrush, int x, int y) {
		magicalBrush.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
		
	}
	
	// Method isSolid() checks if a tile is a solid block
	public boolean isSolid() {
		return false;
	} 
	 
	public int getId() {
		return id;
	}

} // end Tile Class
