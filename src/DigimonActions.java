import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class DigimonActions {
	Digimon digimon = new Digimon();
	
	public DigimonActions(Digimon digi) {
		digimon = digi;
	}
	
	protected void idleWalk() {

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int y = digimon.returnCurrentY();
				digimon.setNewLocation(20, y);
			}
		};

		
		int delay = 5000;
		new Timer(delay, taskPerformer).start();

	}
	
	protected void idleStand(ImageIcon image) {
		digimon.setDigimonImage(image);
	}
	
	protected void sleep(ImageIcon image) {
		// update status by increasing health maybe. Or add something else.
		// I need to figure it out and add it later
		digimon.setDigimonImage(image);
	}
}
