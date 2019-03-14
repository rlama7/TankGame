/**
 * Game.java		--A program responsible to run the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             10/27/2018
 */

package dev.ratnalama.tankgame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ratnalama.tankgame.display.Display;
import dev.ratnalama.tankgame.entity.collidable.BulletController;
import dev.ratnalama.tankgame.graphics.Assets;
import dev.ratnalama.tankgame.graphics.GameCamera;
import dev.ratnalama.tankgame.input.KeyManager;
import dev.ratnalama.tankgame.input.MouseManager;
import dev.ratnalama.tankgame.states.GameState;
import dev.ratnalama.tankgame.states.MenuState;
import dev.ratnalama.tankgame.states.State;

public class Game implements Runnable{
	

	private Display display;
	
	private int width, height;
	private String title;
	
	private boolean isRunning = false;
	private Thread thread;
	
	private BufferStrategy buffer; // draw graphics to buffer before drawing to the screen
	private Graphics magicalBrush; // draws graphics (line, and shapes) to the canvas...magically!
	
	// States
	private State gameState;
	private State menuState;
	
	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//private BufferedImage testImage;
	//private SpriteSheet sheet;
	
	// Camera
	private GameCamera gameCamera;
	
	// Handler
	private Handler handler;
	
	// BulletController
	private BulletController bulletController;
	
	
	// Constructor
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
	} // end Constructor
	
    // Method init initializes all the graphics for the game to begin
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		bulletController = new BulletController(handler);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	} // end init()
	
	
    // Method tick updates the game
	private void tick() {
		keyManager.tick();
		
		// Check if we have a single state to update
		if (State.getState() != null) {
			State.getState().tick();			
		}
		
	} // end tick()
	
	
	/**
	 * Method render draws the game
     * avoids screen flickering by drawing out
     * graphics to the buffer first, and then displaying
     * what's in the buffer to the screen - essential for
     * smooth frame transition and better viewing experience
     */
	private void render() {
		buffer = display.getCanvas().getBufferStrategy();
		
		// check if the canvas has a buffer to draw graphics
		if (buffer == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		magicalBrush = buffer.getDrawGraphics();
		
		// Clear screen
		magicalBrush.clearRect(0, 0, width, height);
		
		
		/*--------------------------------------Draw Here----------------------------------------*/ 
		
		// Check if we have a single state to render
		if (State.getState() != null) {
			State.getState().render(magicalBrush);
		}		
		buffer.show();
		magicalBrush.dispose();	
		
	} // end render()


	@Override
	// Implementation from Runnable class to run the game on a new thread for game performance efficiency
	public void run() {
		init();
		
		int fps = 60; // tick 60 frame per seconds
		int nanoSecond = 1000000000;
		// max amount of time in nanosecond that tick() and render() are to be executed to achieve 60 fps 
		double timePerTick = (nanoSecond/fps); 
		double delta = 0;	// wait time until tick() and render() are called again
		long now;
		long lastTime = System.nanoTime();	// return current time in nanosecond
		long timer = 0;
		int ticks = 0;
		
		while (isRunning) {
			now = System.nanoTime();	// current time of computer
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			// Check when to call tick() and render() to achieve 60fps
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;				
			}
			
			// Display number of ticks after each nanosecond is lapsed
			if (timer >= nanoSecond) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;			
			}						
		} // end while loop
		stop();
	} // end run()
	
		
	// Starts new thread to run the Game object
	public synchronized void start() {
		// check if the game is already running
		if (isRunning) {
			return;
		}
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	} // end start()
	
	public synchronized void stop() {
		// check if the game is already stopped
		if (!isRunning) {
			return;			
		}
		
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // end try-catch
		
	} // end stop()
	
	
	/* ------------------BEGIN Getters ------------------------- */
	public BulletController getBulletController() {
		return bulletController;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public State getGameState() {
		return gameState;
	}
	
	public State getMenuState() {
		return menuState;
	}	
	/* ------------------END Getters --------------------------- */

} // end Game Class
