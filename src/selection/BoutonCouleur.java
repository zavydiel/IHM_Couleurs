package selection;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
	

public class BoutonCouleur extends JPanel{
	public BoutonCouleur(int i) {
		JPanel color = new JPanel();
		color.setBackground();
		setCouleurActuelle();
		color.setPreferredSize(new Dimension(50,50));
		color.setMaximumSize(new Dimension(50,50));


	}
	
	public Color getCouleur(int i) {
		return getPalette().getGLCouleur(i).getColor();
		}
}
