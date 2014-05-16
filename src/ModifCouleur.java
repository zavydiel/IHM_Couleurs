import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ModifCouleur extends JPanel {
	JPanel parent;
	
	public ModifCouleur(JPanel parent) {
		super();
		this.parent = parent;
		this.add(new JLabel("toto"));
	}
}
