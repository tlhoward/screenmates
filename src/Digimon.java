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
		x = (int) screen.getMaxX() - idleStandingImage_left.getIconWidth();
		y = (int) screen.getMaxY() - idleStandingImage_left.getIconHeight() - taskbarheight;  // right above taskbar		
		
		setSize(idleStandingImage_left.getIconWidth(), idleStandingImage_left.getIconHeight());
		setLocation(x, y);
	}
		
    private void initComponents() {
    	contentPane = (JPanel) getContentPane();
        imageLabel = new JLabel(idleStandingImage_left);		// set initial image to imageLabel
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
        
    protected void imgDigimonIdle(String side) {
    	if (side == "left")
    		imageLabel.setIcon(idleStandingImage_left);
    	else
    		imageLabel.setIcon(idleStandingImage_right);
    }
    
    protected void imgDigimonWalk(String side) {
    	if (side == "left")
    		imageLabel.setIcon(walkingImage_left);
    	else
    		imageLabel.setIcon(walkingImage_right);    	
    }
    
	// variables declaration
	private ImageIcon idleStandingImage_left = new ImageIcon(getClass().getResource("/guilmon/animated_gifs/guilmon_stand(idle).gif"));		// idle while standing
	private ImageIcon idleStandingImage_right = new ImageIcon(getClass().getResource("/guilmon/animated_gifs/guilmon_stand(idle)_right.gif"));
	private ImageIcon idleSittingImage;			// idle while sitting
	private ImageIcon walkingImage_left = new ImageIcon(getClass().getResource("/guilmon/animated_gifs/guilmon_walk.gif"));
	private ImageIcon walkingImage_right = new ImageIcon(getClass().getResource("/guilmon/animated_gifs/guilmon_walk_right.gif"));
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
