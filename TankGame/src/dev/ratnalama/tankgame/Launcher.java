/**
 * Launcher.java	--A program responsible for launching game application.
 * @author            Ratna Lama
 * @version           1.0
 * @since             10/27/2018
 */

package dev.ratnalama.tankgame;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Tank Game", 1270, 630);
		game.start();
	} // end main method()
} // end Launcher Class
