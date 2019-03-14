package dev.ratnalama.tankgame.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	
	// Constructor
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	} // end Constructor
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);		
	} // end crop()

} // end SpriteSheet
