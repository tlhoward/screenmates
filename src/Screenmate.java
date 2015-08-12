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
	
	private class FormListener implements java.awt.event.MouseListener {
		FormListener() {}
	
		public void mouseClicked(java.awt.event.MouseEvent anEvent) {
			if (anEvent.getSource() == imageLabel) {
				imageClicked(anEvent);
			}
		}
	
	    public void mouseEntered(java.awt.event.MouseEvent evt) {
	    }
	
	    public void mouseExited(java.awt.event.MouseEvent evt) {
	    }
	
	    public void mousePressed(java.awt.event.MouseEvent evt) {
	    }
	
	    public void mouseReleased(java.awt.event.MouseEvent evt) {
	    }
	}
	
    protected void initComponents() {

        imageLabel = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        imageLabel.addMouseListener(formListener);
        getContentPane().add(imageLabel, java.awt.BorderLayout.CENTER);

        pack();
    }
    
	
	/* Right now right click will exit. Later it'll bring up a menu
	 * that has the option to exit as well as other stuff.
	 */
	private void imageClicked(java.awt.event.MouseEvent anEvent) {
		if (anEvent.getButton() == MouseEvent.BUTTON3) // BUTTON3 is right click
			System.exit(0);
	}

	
	// variables declaration
    private javax.swing.JLabel imageLabel;
    
    private int pos;		// digimon's position
    private int imgNo;		// image number
}