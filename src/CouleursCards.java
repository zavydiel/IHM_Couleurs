import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CouleursCards extends JPanel {
	
	private JFrame fenetre;
	CardLayout cartes;
	
	public CouleursCards(JFrame fenetre) {
		super();
		cartes = new CardLayout();
		this.setPreferredSize(new Dimension(300, 500));
		this.add(new ChoixCouleur(fenetre), "choix");
		this.add(new ModifCouleur(fenetre), "modif");
		this.fenetre = fenetre;
		this.setSize(getMaximumSize());
	}
}
