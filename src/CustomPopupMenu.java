import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.MouseInputAdapter;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class CustomPopupMenu extends JPopupMenu {
	JPopupMenu popup;
	JFrame frame;
	static Status stats;
	
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
				else if(source == statsOption) {
					showStateWindow();
				}
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
				showPopupMenu(anEvent);
			}
		}
	
	}
	
	protected void addPopupListenerToImage(JLabel imageLabel) {
		MouseListener popupListener = new PopupListener(popup, imageLabel);
		imageLabel.addMouseListener(popupListener);
	}
	
	/* Right now right click will exit. Later it'll bring up a menu
	 * that has the option to exit as well as other stuff.
	 * 
	 * Alright, now it brings up a menu.
	 */
	private void showPopupMenu(MouseEvent anEvent) {
		if (anEvent.getButton() == MouseEvent.BUTTON3) { // BUTTON3 is right click
			CustomPopupMenu menu = new CustomPopupMenu();
			menu.show(anEvent.getComponent(), anEvent.getX(), anEvent.getY());
		}
	}
	
	/*
	 * Ideally this is the separate window that shows the stats and stuff
	 */
	private void showStateWindow() {
		JOptionPane.showMessageDialog(frame,
			    "Someday I'll add the stats here or something.",
			    "Current Stats",
			    JOptionPane.PLAIN_MESSAGE);
	}
	
}
