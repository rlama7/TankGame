/**
 * Display.java		--A program responsible to display game window.
 * @author            Ratna Lama
 * @version           1.0
 * @since             10/27/2018
 */

package dev.ratnalama.tankgame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;	// display graphics
	private Canvas canvas;	// draw graphics
	
	private String title;
	private int width, height;
	
	// Constructor 
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	} // end Constructor
	
	/**
     * createDisplay method displays window
     */
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window and game properly
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // set window to the center
		frame.setVisible(true);
		
		// initialize canvas for drawing graphics
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		// add canvas to JFrame for displaying graphics to the screen
		frame.add(canvas);
		frame.pack();	// make canvas fit JFrame can display graphics properly		
		
	} // end createDisplay()

	/* ---------------------BEGIN Getters--------------------------------- */
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	/* ---------------------END Getters----------------------------------- */

} //end Display Class
