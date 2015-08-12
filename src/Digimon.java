import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;


public class Digimon extends JWindow {

	// Initializes a digimon, though it's only guilmon right now
	public void initDigimon() {
		
		JPanel contentPane = (JPanel) getContentPane();
		Screenmate scrnmt = new Screenmate();
		loadGuilmon();

		// Set window to transparent
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
		

		
		
		scrnmt.initComponents();
		setSize(idleStandingImage.getIconWidth(), idleStandingImage.getIconHeight());
//		setLocationRelativeTo(null);
		
		idleStandingImage.setImageObserver(this);
		
		JLabel imageLabel = new JLabel(idleStandingImage);

		contentPane.add(imageLabel);

		
		setLocation(x, y);
	}
	


	
	private void loadGuilmon() {
		idleStandingImage = new ImageIcon(getClass().getResource("images/stand_pixel.gif"));
	}
	
	// variables declaration
	private ImageIcon idleStandingImage;		// idle while standing
	private ImageIcon idleSittingImage;			// idle while sitting
	private Rectangle digimonBounds = new Rectangle();
	private Timer timer;
	private JLabel imageLabel;
	
	private int x, y;
	private int ox, oy;
	
}
