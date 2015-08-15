import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.Timer;


public class Digimon extends JWindow {

	// Initializes a digimon, though it's only guilmon right now
	public void initDigimon() {
		
		JPanel contentPane = (JPanel) getContentPane();
		loadGuilmon();
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
		y = (int) screen.getMaxY() - idleStandingImage.getIconHeight() - taskbarheight;		
		
		setSize(idleStandingImage.getIconWidth(), idleStandingImage.getIconHeight());
		setLocation(x, y);
	}
	

	private void loadGuilmon() {
		idleStandingImage = new ImageIcon(getClass().getResource("guilmon_stand(idle).gif"));
	}
	
	
    protected void initComponents() {
        imageLabel = new JLabel(idleStandingImage);		// set initial image to imageLabel
        CustomPopupMenu popup = new CustomPopupMenu();
        popup.addPopupListenerToImage(imageLabel);		// add popup menu to imageLabel
        getContentPane().add(imageLabel);

        pack();
    }
	

	// variables declaration
	private ImageIcon idleStandingImage;		// idle while standing
	private ImageIcon idleSittingImage;			// idle while sitting
	private Rectangle digimonBounds = new Rectangle();
	private Timer timer;
	private JLabel imageLabel;
	
	private int x, y;
	
}
