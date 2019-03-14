/**
 * Assets.java		--A program responsible to display game assets.
 * @author            Ratna Lama
 * @version           1.0
 * @since             10/27/2018
 */

package dev.ratnalama.tankgame.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;	// grid space dimension
	
	public static Font font12, font16, font28, font32;
	
	public static BufferedImage brownWall, gravelWall, greenWall, palmTree, darkBrownWall, 
								redTank, explosion1, leftBullet, greenTank, explosion2,
								rightBullet, tire, grass, stoneWallLeft, stoneWallMiddle,
								stoneWallCorner, rocket01, rocket02, rocket03, rocket04, rewardItem01, menu, wall;
	
	// Animation
	public static BufferedImage[] greenTankUp, greenTankRight, greenTankDown, greenTankLeft,	
								bulletUp, bulletDown, bulletRight, bulletLeft;
	
	// Start button
	public static BufferedImage[] startButton;
	//public static BufferedImage[] startButton;
	
	// Inventory
	public static BufferedImage inventoryScreen;
	
	
	// Initialize game sprite once
	public static void init() {
		// Silk Screen TTF Font
		font12 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 12);
		font16 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 16);
		font28 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 28);
		font32 = FontLoader.loadFont("resources/fonts/slkscrb.ttf", 32);
		
		//SpriteSheet 
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet04D.png"));
		SpriteSheet animationSheet = new SpriteSheet(ImageLoader.loadImage("/textures/greenTankAnimation04.png"));
		SpriteSheet startMenu = new SpriteSheet(ImageLoader.loadImage("/textures/play02.png"));
		SpriteSheet bulletAnimation = new SpriteSheet(ImageLoader.loadImage("/textures/bullet04.png"));
		SpriteSheet rocket = new SpriteSheet(ImageLoader.loadImage("/textures/rocket01.png"));
		SpriteSheet rewardItem = new SpriteSheet(ImageLoader.loadImage("/textures/rewardItem01.png"));
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		SpriteSheet greenGrass = new SpriteSheet(ImageLoader.loadImage("/textures/grass01.png"));
		SpriteSheet brickWall = new SpriteSheet(ImageLoader.loadImage("/textures/brickWall01.png"));
		SpriteSheet gameMenu01 = new SpriteSheet(ImageLoader.loadImage("/textures/gameMenu01.png")); 
		
		// Animation
		greenTankUp = new BufferedImage[2];
		greenTankRight = new BufferedImage[2];
		greenTankDown = new BufferedImage[2];
		greenTankLeft = new BufferedImage[2];
		bulletUp = new BufferedImage[2];
		bulletDown = new BufferedImage[2];
		bulletRight = new BufferedImage[2];
		bulletLeft = new BufferedImage[2];
		
		// StartButton 
		startButton = new BufferedImage[2];
		startButton[0] = startMenu.crop(0, 0, width*4, height*2);
		startButton[1] = startMenu.crop(0, height*2, width*4, height*2);
		
		
		// Animation frames
		greenTankUp[0] = animationSheet.crop(0, 0, width-1, height-1);
		greenTankUp[1] = animationSheet.crop(width-1, 0, width-1, height-1);
		
		greenTankRight[0] = animationSheet.crop((width-1)*2, 0, width-1, height-1);
		greenTankRight[1] = animationSheet.crop((width-1)*3, 0, width-1, height-1);
				
		greenTankDown[0] = animationSheet.crop(0, height-1, width-1, height-1);
		greenTankDown[1] = animationSheet.crop(width-1, height-1, width-1, height-1);
				
		greenTankLeft[0] = animationSheet.crop((width-1)*2, height-1, width-1, height-1);
		greenTankLeft[1] = animationSheet.crop((width-1)*3, height-1, width-1, height-1);
				
		// bullet animation
		bulletUp[0] = bulletAnimation.crop(0, 0, width, height);
		bulletUp[1] = bulletAnimation.crop(0, width, width, height);
		
		bulletDown[0] = bulletAnimation.crop(width, 0, width, height);
		bulletDown[1] = bulletAnimation.crop(width, height, width, height);
		
		bulletRight[0] = bulletAnimation.crop(width*2, 0, width, height);
		bulletRight[1] = bulletAnimation.crop(width*2, height, width, height);
		
		bulletLeft[0] = bulletAnimation.crop(width*3, 0, width, height);
		bulletLeft[1] = bulletAnimation.crop(width*3, height, width, height);
		
		// menu
		
		menu = gameMenu01.crop(0, 0, width, height);
		
		// Other Assets
		brownWall = sheet.crop(0, 0, width, height);
		gravelWall = sheet.crop(width, 0, width, height);
		greenWall = sheet.crop(width*2, 0, width, height);
		palmTree = sheet.crop(width*3, 0, width, height);
		wall = brickWall.crop(0, 0, width, height);
		
		darkBrownWall = sheet.crop(0, height, width, height);
		redTank = sheet.crop(width, height, width, height);
		explosion1 = sheet.crop(width*2, height, width, height);
		leftBullet = sheet.crop(width*3, height, width, height);
		
		greenTank = sheet.crop(0, height*2, width, height);
		explosion2 = sheet.crop(width, height*2, width, height);
		rightBullet = sheet.crop(width*2, height*2, width, height);
		tire = sheet.crop(width*3, height*2, width, height);
		
		grass = greenGrass.crop(0, 0, width, height);
		stoneWallLeft = sheet.crop(width, height*3, width, height);
		stoneWallMiddle = sheet.crop(width*2, height*3, width, height);
		stoneWallCorner = sheet.crop(width*3, height*3, width, height);
		
		rocket01 = rocket.crop(0, 0, width*2, height*2);
		rocket02 = rocket.crop(width*2, 0, width*2, height*2);
		rocket03 = rocket.crop(0, height*2, width*2, height*2);
		rocket04 = rocket.crop(width*2, height*2, width*2, height*2);
		
		// reward item
		rewardItem01 = rewardItem.crop(0, 0, width/2, height/2);
		
	} // end init()
} // end Assets Class
