import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CouleursCards extends JPanel {
	
	private Fenetre fenetre;
	CardLayout cartes;
	
	public CouleursCards(Fenetre fenetre) {
		super();
		cartes = new CardLayout();
		this.setLayout(cartes);
		this.setPreferredSize(new Dimension(300, 500));
		this.add(new ChoixCouleur(this), "choix");
		this.add(new ModifCouleur(this), "modif");
		this.fenetre = fenetre;
		this.setSize(getMaximumSize());
	}
	
	public void afficherCarte(String carte) {
		cartes.show(this, carte);
	}
}
