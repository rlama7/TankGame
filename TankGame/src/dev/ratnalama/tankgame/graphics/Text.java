/**
 * Text.java		--A program responsible to draw fonts to the screen.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/15/2018
 */

package dev.ratnalama.tankgame.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Text {
	
	public static void drawString(Graphics magicalBrush, String text, int xPos, 
			int yPos, boolean center, Color c, Font font) {
		magicalBrush.setColor(c);
		magicalBrush.setFont(font);
		int x = xPos;
		int y = yPos;
		
		if (center) {
			FontMetrics fm = magicalBrush.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2;
			y = (yPos -fm.getHeight() / 2) + fm.getAscent();
		}
		
		magicalBrush.drawString(text, x, y);
	} // end drawString()

} // end Text Class
