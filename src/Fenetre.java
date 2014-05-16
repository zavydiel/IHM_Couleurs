import java.awt.CardLayout;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	CardLayout cartes = new CardLayout();
	
	public Fenetre() {
		super("Selecteur de couleurs");
		this.setLayout(cartes);
		setSize(1366, 768);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new EcranSelection(this), "selection");
		this.add(new EcranExportation(this), "exportation");
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new Fenetre();
		fenetre.setVisible(true);
	}
}
