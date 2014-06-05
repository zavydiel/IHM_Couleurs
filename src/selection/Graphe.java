package selection;
import java.awt.*;

import fenetre.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import couleurs.GLCouleur;
import couleurs.CouleursContainer;

public class Graphe extends JPanel {

	private JFrame fenetre;
	
	public Graphe(JFrame parent) {
		super();
		this.fenetre = parent;
		//System.out.println(((Fenetre) parent).getPalette().getTaille());
		Dimension taille = new Dimension(600,200);
		this.setMaximumSize(taille);
		this.setPreferredSize(taille);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g) {
		if(((Fenetre) fenetre).getPalette() != null) {
			CouleursContainer pal = ((Fenetre) fenetre).getPalette();
			int largeur = 50;
			int nbCouleur = pal.getTaille();
			int x = (this.getWidth() - nbCouleur * largeur) / 2;
			int y = 200;
			int cpt = 0;
			
			while(cpt < ((Fenetre) fenetre).getPalette().getTaille()) {
				GLCouleur kulle = ((Fenetre) fenetre).getPalette().getGLCouleur(cpt);
				g.setColor(kulle.getColor());
				int hauteur = 80 + (int) (Math.random() * 100);
				g.fillRect(x  + largeur * cpt , y-hauteur, largeur , hauteur);
				cpt++;
			}
		}
	}
}
