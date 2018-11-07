import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
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
				createAndShowSystemTrayIcon();
				start();
			}
		});
	}
	
	public static void start() {
		DigimonActions guilmonActions = new DigimonActions(guilmon);
		guilmonActions.beginAction("walk");	
	}
	
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

    
/* Creates System Tray Icon and sets up menu.
 * Left click icon to make digimon visible or not visible on desktop.
 * Program is still running in the "background" even when not visible.
 * 
 * TODO: have pop-up notifications when stuff happens. Maybe only when digimon isnt visible?
 */
    private static void createAndShowSystemTrayIcon() {
        //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        Image image = Toolkit.getDefaultToolkit().getImage("images/egg.png");
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(image, "Screenmate", popup);
        final SystemTray tray = SystemTray.getSystemTray();
        trayIcon.setImageAutoSize(true);
   
        // Create a pop-up menu components
        MenuItem aboutItem = new MenuItem("About");
        MenuItem exitItem = new MenuItem("Exit");
       
        //Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.addSeparator();
        popup.add(exitItem);
         
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
       
        trayIcon.setPopupMenu(popup);
        trayIcon.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if (e.getButton() == MouseEvent.BUTTON1 && guilmon.isVisible()) {
        			guilmon.setVisible(false);
        		}
        		else
        			guilmon.setVisible(true);
        	}
        });
       
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }
    
}