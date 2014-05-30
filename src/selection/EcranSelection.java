package selection;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import couleurs.CouleursContainer;
import fenetre.Fenetre;


public class EcranSelection extends JPanel {
	
	Fenetre fenetre;
	Color couleur;
	
	private JPanel cartes = new JPanel();
	
	public EcranSelection(Fenetre fenetre) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.fenetre = fenetre;

		
		cartes.setLayout(new CardLayout());
		cartes.add(new ChoixCouleur(this), "choix");
		cartes.add(new ModifCouleur(this), "modif");
		
		this.add(new Apercu(fenetre));
		this.add(cartes);

	}
	
	public void setCouleurActuelle(int i) {
		this.couleur = couleur;
	}
	
	public Color getCouleurActuelle() {
		return this.couleur;
	}
	
	public void permuterCarte() {
		((CardLayout) cartes.getLayout()).next(cartes);
	}
	
	public CouleursContainer getPalette() {
		return ((Fenetre) fenetre).getPalette();
	}
	
	
}
