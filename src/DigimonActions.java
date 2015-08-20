import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class DigimonActions {
	Digimon digimon = new Digimon();
	
	public DigimonActions(Digimon digi) {
		digimon = digi;
		y = digimon.returnCurrentY();
		x = digimon.returnCurrentX();
	}
	
	protected void idleWalk() {

		rand = new Random();
		delay = 500; // 15000 milliseconds, 15 seconds
		newX = rand.nextInt(1600);
		timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				digimon.setDigimonImage(new ImageIcon(getClass().getResource("guilmon_walk.gif")));
				idleWalkHelper(evt);
			}
		});
		timer.setRepeats(true);
		timer.start();
	}
	
	protected void idleWalkHelper(ActionEvent evt) {
		// change delay to random numbers so digimon wont walk exact same length
		// every time
		// also switch directions every so often. have that be random too
		// walk different distances as well. set x as random number, keep y same



	
		// if digimon's new location is larger than old location, then it will need
		// to walk right. add to x until it reaches new position
		if(newX > x) {
			x += 30;
			digimon.setNewLocation(x, y);
			if( newX <= x) {
				((Timer)evt.getSource()).stop();
				digimon.setDigimonImage(new ImageIcon(getClass().getResource("guilmon_stand(idle).gif")));
			}
		}
		else if (newX < x) {
			x -= 30;
			digimon.setNewLocation(x, y);
			if( newX >= x) {
				((Timer)evt.getSource()).stop();
				digimon.setDigimonImage(new ImageIcon(getClass().getResource("guilmon_stand(idle).gif")));
			}
		}
			


	}
	
	protected void idleStand() {
		digimon.setDigimonImage(new ImageIcon(getClass().getResource("guilmon_stand(idle).gif")));
	}
	
	protected void sleep() {
		// update status by increasing health maybe. Or add something else.
		// I need to figure it out and add it later
		//digimon.setDigimonImage(image);
	}
	
	private Random rand;
	private int newX;
	private int delay;
	private Timer timer;
	private int x;
	final int y;
}
