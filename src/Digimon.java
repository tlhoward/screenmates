import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.Timer;


public class Digimon extends JWindow {
	
	// Initializes a digimon, though it's only guilmon right now. Ideally we can choose what digimon to start off with,
	// so then we can load all of the correct images in this class and not have to worry about the others.
	protected void initDigimon() {
		// Get size of user's screen
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
		Rectangle screen = defaultScreen.getDefaultConfiguration().getBounds();

		int taskbarheight = (int) (Toolkit.getDefaultToolkit().getScreenSize().height 
			    - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight());
		x = (int) screen.getMaxX() - idleStandingImage_left.getIconWidth();
		y = (int) screen.getMaxY() - idleStandingImage_left.getIconHeight() - taskbarheight;  // right above taskbar		
		
		initComponents();

		// Set window properties
		getRootPane().putClientProperty("Window.shadow", false);
		setBackground(new Color(0,0,0,0));
		setAlwaysOnTop(true);
		contentPane.setOpaque(false);
		
		setSize((int) screen.getMaxX(), (int) screen.getMaxY() - taskbarheight);
		//setLocation(0, 0);
	}
		
    private void initComponents() {
    	contentPane = (JPanel) getContentPane();
    	contentPane.setLayout(null);
        imageLabel = new JLabel(idleStandingImage_left);		// set initial image to imageLabel
        Dimension size = imageLabel.getPreferredSize();
        imageLabel.setBounds(x, y, size.width, size.height);
        CustomPopupMenu popup = new CustomPopupMenu();
        popup.addPopupListenerToImage(imageLabel);		// add mouse listener to imageLabel
        imageLabel.setLocation(x, y);        
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
    	imageLabel.setLocation(newX,newY);
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
	
	private static JFrame frame = new javax.swing.JFrame();
	
	private int x, y;
	
}

class SavedState implements Serializable {
	Digimon digimon;
	
	public SavedState (Digimon digimon) {
		this.digimon = digimon;
	}
}
