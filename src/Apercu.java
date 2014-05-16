import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class Apercu extends JPanel {
	protected JLabel apercu;
	
	public Apercu(JFrame parent) {
		super();
		setPreferredSize(new Dimension(900,500));
		Graphe graph = new Graphe();
		this.apercu = new JLabel("Apercu");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(apercu);
		add(graph);
		
		apercu.setAlignmentX(CENTER_ALIGNMENT);
		graph.setAlignmentX(CENTER_ALIGNMENT);
	}
}
