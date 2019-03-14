/**
 * EntityManager.java	--A program responsible to manage various entities of the game world.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  11/04/2018
 */


package dev.ratnalama.tankgame.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.entity.creature.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player1, player2;
	
	private ArrayList<Entity> entities;		// entities is an ArrayList that holds Entity objects
	
	// Begin Comparator
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		
		@Override
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			} else {
				return 1;
			}			
		} // end compare()
	}; // end Comparator Class
	
	// Constructor
	public EntityManager(Handler handler, Player player1, Player player2) {
		this.handler = handler;
		this.player1 = player1;
		this.player2 = player2;
		entities = new ArrayList<Entity>();
		addEntity(player1);
		addEntity(player2);
	} // end Constructor
	
	// update all entities
	public void tick() {
		Iterator<Entity> itr = entities.iterator();
		
		while (itr.hasNext()) {
			Entity e = itr.next();
			e.tick();
			if (!e.isActive()) {
				itr.remove();
			}
		}
		entities.sort(renderSorter);
		
	} // end tick()
	
	
	// draw all entities
	public void render(Graphics magicalBrush) {
		for (Entity e : entities) {
			e.render(magicalBrush);
		}
		player1.postRender(magicalBrush);
		player2.postRender(magicalBrush);		
	} // end render()
	
	// add entities
	public void addEntity(Entity e) {
		entities.add(e);	// add to the entities ArrayList
	}


	/* ----------------------BEGIN Getters and Setters----------------------------------- */
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	/* ----------------------END Getters and Setters------------------------------------- */

} // end EntityManagerClass
