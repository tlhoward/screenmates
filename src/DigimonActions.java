import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class DigimonActions {
	Digimon digimon = new Digimon();
	
	public DigimonActions(Digimon digi) {
		digimon = digi;
	}
	
	protected void idleWalk() {

		delay = 3000; // 3000 milliseconds, 3 seconds

		timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				idleWalkHelper();
			}
		});
		
		timer.setRepeats(true);
		timer.start();

	}
	
	protected void idleWalkHelper() {
		// change delay to random numbers so digimon wont walk exact same length
		// every time
		// also switch directions every so often. have that be random too
		// walk different distances as well. set x as random number, keep y same
		
		Random rand = new Random();
		
		int x = rand.nextInt(1600);
		int y = digimon.returnCurrentY();
		digimon.setNewLocation(x, y);
	}
	
	protected void idleStand(ImageIcon image) {
		digimon.setDigimonImage(image);
	}
	
	protected void sleep(ImageIcon image) {
		// update status by increasing health maybe. Or add something else.
		// I need to figure it out and add it later
		digimon.setDigimonImage(image);
	}
	
	private int delay;
	private Timer timer;
}
