import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

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

public class Screenmates extends JWindow {
	
	static Digimon guilmon;
	static Status stats;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				guilmon = new Digimon();
				guilmon.initDigimon();
				stats = new Status();
				stats.setNewState();
				guilmon.setVisible(true);
				start();
			}
		});
	}
	
	public static void start() {
		DigimonActions guilmonActions = new DigimonActions(guilmon);

				guilmonActions.beginAction("walk");	
	}
	
	private int sleepTime;
	
    private void SaveDigimonState() {
    	try {
    		SavedState state = new SavedState(guilmon);
    		OutputStream file = new FileOutputStream("screenmate.mine");
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void LoadDigimonState() {
    	SavedState state;
    	InputStream file;
    }
}