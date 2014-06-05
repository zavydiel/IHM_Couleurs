package selection;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import couleurs.CouleursContainer;
import couleurs.GLCouleur;
import fenetre.Fenetre;


public class EcranSelection extends JPanel {
	
	private Fenetre fenetre;
	private int couleurActuelle = 0;
	private ModifCouleur modif = new ModifCouleur(this);
	private Apercu apercu;
	
	private JPanel cartes = new JPanel();
	
	public EcranSelection(Fenetre fenetre) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.fenetre = fenetre;

		
		cartes.setLayout(new CardLayout());
		cartes.add(new ChoixCouleur(this), "choix");
		cartes.add(modif, "modif");
		
		apercu = new Apercu(fenetre);
		
		this.add(apercu);
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
	
	public void actualiserApercu() {
		apercu.repaint();
	}
}
