import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.Timer;


/*
 * This program (should) load Guilmon!
 * Functionality of the program will be updated as I draw 
 * out the images, but in this first version
 * Guilmon will appear on the bottom right corner of your
 * desktop. I'll have him drop in later. 
 * 
 * Right now he only stands and sits. I need to figure out how
 * to draw his walk cycle. Right click Guilmon to end program.
 */

public class Screenmate extends JWindow {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Digimon guilmon = new Digimon();
				guilmon.initDigimon();
				guilmon.setVisible(true);  // WHY?!
				
			}
		});

	}
    

	
	// variables declaration
    private javax.swing.JLabel imageLabel;
    
    private int pos;		// digimon's position
    private int imgNo;		// image number
}