package dev.ratnalama.tankgame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ratnalama.tankgame.graphics.Assets;

public class UImageButton extends UIObject{ 
	private BufferedImage[] images;
	private ClickListener clicker;

	// Constructor
	public UImageButton(float x, float y, int width, int height, BufferedImage[] images, 
			ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		
	} // end Constructor

	// update
	@Override
	public void tick() {}

	// draw
	@Override
	public void render(Graphics magicalBrush) {
		if (hovering) {
			magicalBrush.drawImage(images[1], (int) x, (int) y, width, height, null);
		} else {
			magicalBrush.drawImage(images[0], (int) x, (int) y, width, height, null);
		}
	} // end render()

	// on click event
	@Override
	public void onClick() {
		clicker.onClick();		
	} // end onClick()
} // end UImageButton Class
