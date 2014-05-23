package selection;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import fenetre.Fenetre;


public class EcranSelection extends JPanel {
	
	Fenetre fenetre;
	
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
	
	public void permuterCarte() {
		((CardLayout) cartes.getLayout()).next(cartes);
	}
}
