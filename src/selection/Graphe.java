package selection;
import java.awt.*;
import fenetre.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import couleurs.GLCouleur;
import couleurs.Palette;

public class Graphe extends JPanel {

	JFrame fenetre;
	
	public Graphe(JFrame parent) {
		super();
		this.fenetre = parent;
		//System.out.println(((Fenetre) parent).getPalette().getTaille());
		Dimension taille = new Dimension(800,200);
		this.setMaximumSize(taille);
		this.setPreferredSize(taille);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	public void paintComponent(Graphics g) {
		if(((Fenetre) fenetre).getPalette() != null) {
			int x = 60;
			int y = 200;
			int hauteur = 100;
			int largeur = 20;
			int cpt = 0;
			int nbCouleur = 8;
			Palette pal = ((Fenetre) fenetre).getPalette();
			//System.out.println(parent.GetPalette().getTaille());
			
			while(cpt < ((Fenetre) fenetre).getPalette().getTaille()) {
				GLCouleur kulle = pal.getGLCouleur(cpt);
				g.setColor(kulle.getColor());
				g.fillRect((x + (800/nbCouleur)*cpt) -largeur , y-hauteur, largeur , hauteur );
				cpt++;
			}
		}
	}
}