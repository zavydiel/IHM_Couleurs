package selection;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ModifCouleur extends JPanel {
	JPanel parent;
	Color couleur;

	public ModifCouleur(JPanel parent) {
		super();
		this.parent = parent;
		this.add(new JLabel(""+this.couleur.toString()));
	}
}
