/**
 * ImageLoader.java		--A program responsible to load the graphics.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  10/27/2018
 */
package dev.ratnalama.tankgame.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	
	// Method loadImage returns the buffered image of loaded image
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
		
	} // end loadImage()

} // end ImageLoader
