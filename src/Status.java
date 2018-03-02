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
	private static int health;
	private static int hunger; // 0 not hungry, 100 very hungry!
	private static int bowels;
	private static int happiness; // 0 sad, 100 happy
	
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
	
	public static int getHealth() {
		return health;
	}
	
	public static int getHunger() {
		return hunger;
	}
	
	public static int getBowels() {
		return bowels;
	}
	
	public static int getHappiness() {
		return happiness;
	}
	
	/* TODO: Set restrictions on input. User doesn't actually input data themselves,
	 * but we still want to make sure to keep values 0-100. Also, I guess we need to
	 * check whether or not it's at max or min value. Probably should make a pop-up or
	 * special image animation that shows whenever it happens for various stuff.
	 */
	
	public static void setHealth(int x) {
		health += x;
	}
	
	public void setHunger(int x) {
		hunger += x;
	}
	
	public static void setBowels(int x) {
		bowels += x;
	}
	
	public void setHappiness() {
		this.happiness += happiness;
	}
	
}

//class SavedState implements Serializable {
//	Digimon digimon;
	
//	public SavedState (Digimon digimon) {
//		this.digimon = digimon;
//	}
//}
