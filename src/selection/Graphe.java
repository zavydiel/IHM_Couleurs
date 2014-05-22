package selection;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Graphe extends JPanel {

	public Graphe() {
		super();
		Dimension taille = new Dimension(800,200);
		this.setMaximumSize(taille);
		this.setPreferredSize(taille);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	public void paintComponent(Graphics g) {
		int x = 60;
		int y = 200;
		int hauteur = 100;
		int largeur = 20;
		int cpt = 0;
		int nbCouleur = 8;

		while(cpt < nbCouleur) {
			g.setColor(Color.BLUE);
			g.fillRect((x + (800/nbCouleur)*cpt) -largeur , y-hauteur, largeur , hauteur );
			cpt++;
		}
	}
}
