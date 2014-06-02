package fenetre;

import java.awt.CardLayout;

import javax.swing.JFrame;

import couleurs.CouleursContainer;
import selection.EcranSelection;
import exportation.EcranExportation;


@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	private CardLayout cartes;
	private CouleursContainer palette;
	
	public Fenetre() {
		super("Selecteur de couleurs");
		palette = new CouleursContainer(5);
		cartes = new CardLayout();
		this.getContentPane().setLayout(cartes);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(new EcranSelection(this), "selection");
		this.getContentPane().add(new EcranExportation(this), "exportation");
		
		
		
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new Fenetre();
		fenetre.setVisible(true);
	}
	
	public void permuterEcran() {
		cartes.next(this.getContentPane());
	}
	
	public CouleursContainer getPalette() {
		return palette;
	}
}
