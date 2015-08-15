import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class CustomPopupMenu extends JPopupMenu {
	JMenuItem exitOption;
	JMenuItem fillerOption;
	JPopupMenu popup;
	
	public CustomPopupMenu() {
		ActionListener menuListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JMenuItem source = (JMenuItem)(event.getSource());
				if(source == exitOption)
					System.exit(0);
			}
		};
		
		// construct and add menu item to popup menu
		exitOption = new JMenuItem("Exit");
		fillerOption = new JMenuItem("Space Filler");
		exitOption.addActionListener(menuListener);
		fillerOption.addActionListener(menuListener);
		add(exitOption);
		add(fillerOption);
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
