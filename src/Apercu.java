import java.awt.Graphics;

import javax.swing.*;

public class Apercu extends JPanel {
	protected JLabel apercu;
	
	public Apercu(JFrame parent) {
		super();
		Graphe graph = new Graphe();
		this.apercu = new JLabel("Aperçu");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(apercu);
		add(graph);
		
		apercu.setAlignmentX(CENTER_ALIGNMENT);
		graph.setAlignmentX(CENTER_ALIGNMENT);
	}
}
