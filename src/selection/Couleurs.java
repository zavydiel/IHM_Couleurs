package selection;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import couleurs.GLCouleur;


public class Couleurs extends JPanel {
	public Couleurs(GLCouleur couleur) {
		Box horizontalBox;
		horizontalBox = Box.createHorizontalBox();
		
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		horizontalBox.add(Box.createGlue());
		JLabel couleurs = new JLabel("\n ");
		couleurs.setMaximumSize(new Dimension(50,50));
		couleurs.setPreferredSize(new Dimension(50,50));
		couleurs.setBackground(couleur.getColor());
		couleurs.setOpaque(true);
		horizontalBox.add(couleurs);
		horizontalBox.add(Box.createGlue());
		
		add(horizontalBox);
	}
}
