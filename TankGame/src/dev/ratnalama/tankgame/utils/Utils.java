/**
 * Utils.java		--A program responsible to represent utility class to cooperate the game world.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/02/2018
 */

package dev.ratnalama.tankgame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	
	// Constructor
	public Utils() {
		
	} // end Constructor
	
	public static String loadFile(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			
			while ((line = br.readLine()) != null) {
				builder.append(line + "\n");				
			}
			br.close();		
			
		} catch (IOException e) {
			e.printStackTrace();
		} // end try-catch
		
		return builder.toString();
	} // end loadFile()
	
	
	public static int parseInt(String number) {
		
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		} // end try-catch
		
	} // end parseInt()	
	
} // end Utils Class
