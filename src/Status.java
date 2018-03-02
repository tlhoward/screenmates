import java.io.Serializable;
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

public class Status implements Serializable {

	Digimon digimon;
	JFrame frame;
	
	// Various stats for digimon. Not sure what to put here yet.
	private int health;
	private int hunger; // 0 not hungry, 100 very hungry!
	private int bowels;
	private int happiness; // 0 sad, 100 happy
	
	// I want to add methods that update the status when various actions are performed. And also
	// it should save it in a file somewhere. I guess. I don't know how it all works yet.
	
//	protected Status () {
//		setNewState();
//	}
	
	/* Stats you start with with a brand new digimon/thingy */
	public void setNewState() {
		health = 100;
		hunger = 50;
		bowels = 0;
		happiness = 50;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getHunger() {
		return this.hunger;
	}
	
	public int getBowels() {
		return this.bowels;
	}
	
	public int getHappiness() {
		return this.happiness;
	}
	
	/* TODO: Set restrictions on input. User doesn't actually input data themselves,
	 * but we still want to make sure to keep values 0-100. Also, I guess we need to
	 * check whether or not it's at max or min value. Probably should make a pop-up or
	 * special image animation that shows whenever it happens for various stuff.
	 */
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	public void setBowels(int bowels) {
		this.bowels = bowels;
	}
	
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
}

//class SavedState implements Serializable {
//	Digimon digimon;
	
//	public SavedState (Digimon digimon) {
//		this.digimon = digimon;
//	}
//}
