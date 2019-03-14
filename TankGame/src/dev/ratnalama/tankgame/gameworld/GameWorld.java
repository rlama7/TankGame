/**
 * GameWorld.java	--A program responsible to represent the game world.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/02/2018
 */

package dev.ratnalama.tankgame.gameworld;

import java.awt.Graphics;

import dev.ratnalama.tankgame.Game;
import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.entity.EntityManager;
import dev.ratnalama.tankgame.entity.collidable.BulletController;
import dev.ratnalama.tankgame.entity.creature.Player;
import dev.ratnalama.tankgame.entity.statics.BreakableWall;
import dev.ratnalama.tankgame.entity.statics.Rocket;
import dev.ratnalama.tankgame.items.ItemManager;
import dev.ratnalama.tankgame.tile.Tile;
import dev.ratnalama.tankgame.utils.Utils;

public class GameWorld {	

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	// Entities
	private EntityManager entityManager;
	
	// Item
	private ItemManager itemManager;
	
	// Bullet
	private BulletController bulletController;
	
	
	// Constructor
	public GameWorld(Handler handler, String path) {
		this.handler = handler;
		
		entityManager = new EntityManager(handler, new Player(handler, 100, 100), new Player(handler, 1080, 1080));
				
		itemManager = new ItemManager(handler);
		
		bulletController = new BulletController(handler);
		
		// add new entity
		// rocket
		entityManager.addEntity(new Rocket(handler, 900, 150));
		entityManager.addEntity(new Rocket(handler, 55, 1110));
		entityManager.addEntity(new Rocket(handler, 610, 595));
		entityManager.addEntity(new Rocket(handler, 316, 850));
		
		// breakable Wall
		entityManager.addEntity(new BreakableWall(handler, 512, 190));
		entityManager.addEntity(new BreakableWall(handler, 512, 958));
		entityManager.addEntity(new BreakableWall(handler, 192, 575));
		entityManager.addEntity(new BreakableWall(handler, 960, 575));
		entityManager.addEntity(new BreakableWall(handler, 575, 450));
		entityManager.addEntity(new BreakableWall(handler, 575, 767));
				
		loadGameWorld(path);	
		
//		entityManager.getPlayer().setX(spawnX);
//		entityManager.getPlayer().setY(spawnY);
	} // end Constructor
	
	// update
	public void tick() {
		bulletController.tick();
		itemManager.tick();
		entityManager.tick();		
		
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
		
		/* ---BEGIN render tiles that are only in the player's view range-------------- */ 
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/ Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/ Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(magicalBrush, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));				
			}
		}
		
		// bullet
		bulletController.render(magicalBrush);
		
		// Items
		itemManager.render(magicalBrush);
		
		// Entities
		entityManager.render(magicalBrush);		
		/* ---END render tiles that are only in the player's view range--------------- */ 
	} // end render()
	
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;			
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if (t == null) {
			return Tile.dirtTile;
		}
		return t;
	} // end getTile()
	
	
	// Loads game world
	private void loadGameWorld(String path) {
		String file = Utils.loadFile(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for	(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width) + 4]);			
			}
		}		 
	} // end loadGameWorld()
	
	
	/* --------------------BEGIN Getters and Setters----------------------------------------- */
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public Handler getHandler() {
		return handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
	public BulletController getBulletController() {
		return bulletController;
	}

	public void setBulletController(BulletController bulletController) {
		this.bulletController = bulletController;
	}
	
	/* --------------------END Getters and Setters------------------------------------------ */

} // end GameWorld Class
