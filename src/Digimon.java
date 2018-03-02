import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.Timer;


public class Digimon extends JWindow {

	// Initializes a digimon, though it's only guilmon right now
	protected void initDigimon() {
		
		loadDigimonImage("/guilmon/animated_gifs/guilmon_stand(idle).gif");
		initComponents();

		// Set window properties
		getRootPane().putClientProperty("Window.shadow", false);
		setBackground(new Color(0,0,0,0));
		setAlwaysOnTop(true);
		contentPane.setOpaque(false);

		// Get size of user's screen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
		Rectangle screen = defaultScreen.getDefaultConfiguration().getBounds();

		int taskbarheight = (int) (Toolkit.getDefaultToolkit().getScreenSize().height 
			    - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight());
		x = (int) screen.getMaxX() - idleStandingImage.getIconWidth();
		y = (int) screen.getMaxY() - idleStandingImage.getIconHeight() - taskbarheight;  // right above taskbar		
		
		setSize(idleStandingImage.getIconWidth(), idleStandingImage.getIconHeight());
		setLocation(x, y);
	}
	
	private void loadDigimonImage(String string) {
		idleStandingImage = new ImageIcon(getClass().getResource(string));
	}
	
    private void initComponents() {
    	contentPane = (JPanel) getContentPane();
        imageLabel = new JLabel(idleStandingImage);		// set initial image to imageLabel
        CustomPopupMenu popup = new CustomPopupMenu();
        popup.addPopupListenerToImage(imageLabel);		// add mouse listener to imageLabel
        contentPane.add(imageLabel);

        pack();
    }
    
    protected JLabel returnImageLabel() {
    	return imageLabel;
    }
	
    protected int returnCurrentX() {
    	return x;
    }
    
    protected int returnCurrentY() {
    	return y;
    }
    
    protected void setX(int newX) {
    	x = newX;
    }
    protected void setY(int newY) {
    	y = newY;
    }
    
    protected void setNewLocation(int newX, int newY) {
    	setLocation(newX,newY);
    }
    
    protected void setDigimonImage(ImageIcon image) {
    	imageLabel.setIcon(image);
    }
    
	// variables declaration
	private ImageIcon idleStandingImage;		// idle while standing
	private ImageIcon idleSittingImage;			// idle while sitting
	private ImageIcon walkingImage;
	private Rectangle digimonBounds = new Rectangle();
	private Timer timer;
	private JLabel imageLabel;
	private JPanel contentPane;
	
	private int x, y;
	
}

class SavedState implements Serializable {
	Digimon digimon;
	
	public SavedState (Digimon digimon) {
		this.digimon = digimon;
	}
}
