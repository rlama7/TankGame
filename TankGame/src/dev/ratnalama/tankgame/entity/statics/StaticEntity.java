/**
 * StaticEntity.java	--A program responsible to represent static entities.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  11/04/2018
 */

package dev.ratnalama.tankgame.entity.statics;

import dev.ratnalama.tankgame.Handler;
import dev.ratnalama.tankgame.entity.Entity;

public abstract class StaticEntity extends Entity {

	// Constructor
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	} // end Constructor

} // end StaticEntity Class
