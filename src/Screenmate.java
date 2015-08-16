import java.awt.*;

import javax.swing.JWindow;


/*
 * This program (should) load Guilmon!
 * Functionality of the program will be updated as I draw 
 * out the images, but in this first version
 * Guilmon will appear on the bottom right corner of your
 * desktop. I'll have him drop in later. 
 * 
 * Right now he only stands and sits. I need to figure out how
 * to draw his walk cycle. Right click to bring up popup menu
 * and select Exit to end program.
 */

public class Screenmate extends JWindow {
	
	static Digimon guilmon;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				guilmon = new Digimon();
				guilmon.initDigimon();
				guilmon.setVisible(true);
				start();
			}
		});
	}
	
	public static void start() {
		DigimonActions guilmonActions = new DigimonActions(guilmon);
		guilmonActions.idleWalk();
	}
	
	private int sleepTime;
}