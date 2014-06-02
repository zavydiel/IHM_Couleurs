package selection;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import couleurs.CouleursContainer;
import couleurs.GLCouleur;
import fenetre.Fenetre;


public class EcranSelection extends JPanel {
	
	Fenetre fenetre;
	int couleurActuelle = 0;
	ModifCouleur modif = new ModifCouleur(this);
	
	private JPanel cartes = new JPanel();
	
	public EcranSelection(Fenetre fenetre) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.fenetre = fenetre;

		
		cartes.setLayout(new CardLayout());
		cartes.add(new ChoixCouleur(this), "choix");
		cartes.add(modif, "modif");
		
		this.add(new Apercu(fenetre));
		this.add(cartes);
	}
	
	public void setCouleurActuelle(int i) {
		this.couleurActuelle = i;
		modif.mettreAJour();
	}
	
	public GLCouleur getCouleurActuelle() {
		return getPalette().getGLCouleur(couleurActuelle);
	}
	
	public int getIndexActuel() {
		return couleurActuelle;
	}
	
	public void permuterCarte() {
		((CardLayout) cartes.getLayout()).next(cartes);
		this.repaint();
	}
	
	public CouleursContainer getPalette() {
		return ((Fenetre) fenetre).getPalette();
	}
	
	
}
