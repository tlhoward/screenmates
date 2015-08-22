import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JWindow;
import javax.swing.Timer;


/*
 * This program (should) load Guilmon!
 * Functionality of the program will be updated as I draw 
 * out the images, but in this first version
 * Guilmon will appear on the bottom right corner of your
 * desktop. I'll have him drop in later. 
 * 
 * Now he walks left and stands there. Eh.
 * 
 * Right click to bring up popup menu
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
		
		int delay = 15000;
		Timer timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				guilmonActions.idleWalk();
			}
		});
		timer.setRepeats(true);
		timer.start();
			
	}
	
	private int sleepTime;
}