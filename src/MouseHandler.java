import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class MouseHandler extends MouseAdapter {
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
		JLabel imageLabel;
		JPanel contentPane;
		Digimon digi;
		
	
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
	    	offset = anEvent.getPoint();
	    }
	
	    public void mouseReleased(MouseEvent anEvent) {
	    }
	    
	    public void mouseDragged(MouseEvent anEvent) {
            int x = anEvent.getPoint().x - offset.x;
            int y = anEvent.getPoint().y - offset.y;
            Component component = anEvent.getComponent();
            
            
            Point location = component.getLocation();
            location.x += x;
            location.y += y;
            JPanel panel = (JPanel) component.getParent();
            Point panelLocation = panel.getLocation();
            panelLocation.x += x;
            panelLocation.y += y;
            panel.setLocation(panelLocation);
            component.setLocation(location);
	    }

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	
	
	private Point offset;
}
