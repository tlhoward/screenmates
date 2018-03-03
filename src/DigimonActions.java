import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.event.MouseInputAdapter;

import java.awt.Component;

/* Will hopefully have various actions the digimon will do. 
 * 
 * Also houses behavior when mouse clicks and drags the image. Ideally.
 */

public class DigimonActions {
	Digimon digimon = new Digimon();

	public DigimonActions(Digimon digi) {
		digimon = digi;
		y = digimon.returnCurrentY();
		x = digimon.returnCurrentX();
		MyListener mouseListener = new MyListener(digi.returnImageLabel(), digimon);
		digi.returnImageLabel().addMouseListener(mouseListener);
	}
	
	public void beginAnimation() {
			idleWalk();
	}
	
	
	protected void idleWalk() {
		rand = new Random();
		delay = 500; // changes how fast guilmon moves across the screen. half a second atm
		newX = rand.nextInt(1600);
		
		
		/* This timer runs every 0.5 seconds and moves guilmon across the screen either left or right. Once guilmon
		 * hits his new position (randomized variable newX) then this timer will stop. 
		 * After 20 seconds, the timer in Screenmates will run again and trigger this method to make him walk once more.
		 * 
		 * What I would like to do later is not use a timer in the Screenmates class, but instead trigger the methods I need
		 * over in here. That way I can do the idleWalk method, or sleep method, or eat method, etc etc.
		 */
		timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(newX >= x)		// if guilmon needs to walk to right, load image and go to idleWalkHelper()
					digimon.imgDigimonWalk("right");
				else				// same ^^^^
					digimon.imgDigimonWalk("left");
				idleWalkHelper(evt);

			}
		});
		timer.setRepeats(true);
		timer.start();
	}
	
	protected void idleWalkHelper(ActionEvent evt) {
		// newX is a random number so digimon wont walk exact same length
		// every time
		// also switch directions every so often. have that be random too
		// walk different distances as well. set x as random number, keep y same
	
		// if digimon's new location is larger than old location, then it will need
		// to walk right. add to x until it reaches new position
		if(newX > x) {
			x += 25;
			digimon.setNewLocation(x, y);
			if( newX < x) {
				((Timer)evt.getSource()).stop();
				idleStand("right");
			}
		}
		else if (newX < x) {
			x -= 25;
			digimon.setNewLocation(x, y);
			if( newX > x) {
				((Timer)evt.getSource()).stop();
				idleStand("left");
			}

		}
		else { // new position ends up being the same as old position. just have him stand there.
			((Timer)evt.getSource()).stop();
			idleStand("left");
		}
	}
	
	protected void idleStand(String str) {
		digimon.imgDigimonIdle(str);
	}
	
	protected static void feed() {
		Status.setHealth(10);
		//insert feeding animation here. he will eat random bread.
	}
	
	protected static void sleep() {
		// update status by increasing health maybe. Or add something else.
		// I need to figure it out and add it later
		//digimon.setDigimonImage(image);
	}
	
	
	/*
	 * HERE IS THE MOUSELISTENER STUFF
	 * 
	 * SCREAMING A LOT
	 * 
	 * THIS IS WHERE I MESSED UP LAST TIME
	 * 
	 * This is where we're supposed to try and drag the little digimon across the screen,
	 * but cant figure out out god
	 */
	protected class MyListener extends Component implements MouseListener, MouseMotionListener {
		
		JLabel imageLabel;
		Digimon digi;
		
		MyListener(JLabel il, Digimon digim) {
			digi = digim;
			imageLabel = il;
		}
		
		public void mouseClicked(MouseEvent anEvent) {
/*	if (anEvent.getSource() == imageLabel
					&& anEvent.getButton() == MouseEvent.BUTTON1) {
			x = 700;
			y = 700;
				digimon.setNewLocation(x, y);
	}
*/		}
	
	    public void mouseEntered(MouseEvent anEvent) {
	    }
	
	    public void mouseExited(MouseEvent anEvent) {
	    }
	
	    public void mousePressed(MouseEvent anEvent) {

	    }
	
	    public void mouseReleased(MouseEvent anEvent) {
	    }
	    
	    public void mouseDragged(MouseEvent anEvent) {
	    	dragX = anEvent.getX();
	    	dragY = anEvent.getY();
	    	digimon.setNewLocation(dragX, dragY);
	    	repaint();
	    }

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
	
	
	
	private Random rand;
	private int newX;
	private int newY;
	private int delay;
	private Timer timer;
	private int x;
	private int y;
	private int dragX;
	private int dragY;
	private boolean leftClickPress = false;

}
