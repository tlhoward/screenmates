import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class CustomPopupMenu extends JPopupMenu {
	JPopupMenu popup;
	
	public CustomPopupMenu() {
		// Initialize various menu options
		JMenuItem statsOption = new JMenuItem("View Stats");
		JMenuItem feedOption = new JMenuItem("Feed");
		JMenuItem playOption = new JMenuItem("Play");
		JMenuItem sleepOption = new JMenuItem("Sleep");
		JMenuItem optionsOption = new JMenuItem("Options");
		JMenuItem exitOption = new JMenuItem("Exit");
		
		// Create Action Listener
		ActionListener menuListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JMenuItem source = (JMenuItem)(event.getSource());
				if(source == exitOption)
					System.exit(0);
			}
		};
		
		// Add action listeners and place them in menu
		statsOption.addActionListener(menuListener);
		feedOption.addActionListener(menuListener);
		playOption.addActionListener(menuListener);
		sleepOption.addActionListener(menuListener);
		exitOption.addActionListener(menuListener);
		add(statsOption);
		add(feedOption);
		add(playOption);
		add(sleepOption);
		addSeparator();
		add(optionsOption);
		add(exitOption);
	}
		
	protected class PopupListener extends MouseAdapter {
		JLabel imageLabel;
		
		PopupListener(JPopupMenu popupMenu, JLabel iL) { 
			popup = popupMenu; 
			imageLabel = iL;
		}

		public void mouseClicked(MouseEvent anEvent) {
			if (anEvent.getSource() == imageLabel) { 	// if image is clicked, show pop up
				showPopup(anEvent);
			}
		}
	
	    public void mouseEntered(MouseEvent anEvent) {
	    }
	
	    public void mouseExited(MouseEvent anEvent) {
	    }
	
	    public void mousePressed(MouseEvent anEvent) {
	    }
	
	    public void mouseReleased(MouseEvent anEvent) {
	    }
	}
	
	protected void addPopupListenerToImage(JLabel imageLabel) {
		MouseListener popupListener = new PopupListener(popup, imageLabel);
		imageLabel.addMouseListener(popupListener);
	}
	
	/* Right now right click will exit. Later it'll bring up a menu
	 * that has the option to exit as well as other stuff.
	 */
	private void showPopup(MouseEvent anEvent) {
		if (anEvent.getButton() == MouseEvent.BUTTON3) { // BUTTON3 is right click
			CustomPopupMenu menu = new CustomPopupMenu();
			menu.show(anEvent.getComponent(), anEvent.getX(), anEvent.getY());
		}
	}

	
}
