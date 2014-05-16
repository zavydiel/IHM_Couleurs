import java.awt.Graphics;

import javax.swing.*;

public class Apercu extends JPanel {
	protected JLabel apercu;
	private JFrame parent;
	
	public Apercu(JFrame parent) {
		super();
		this.parent = parent;
		this.apercu = new JLabel("Aperçu");
		this.setLayout(new BoxLayout(parent.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	public void paint() {
		Graphics g = this.getGraphics();
	}
	
}
