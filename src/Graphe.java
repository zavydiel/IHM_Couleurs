import java.awt.*;
import javax.swing.JPanel;

public class Graphe extends JPanel {
	
	public Graphe() {
		
		setSize(800,400);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(10, 800, 20, 20);
	}
}
