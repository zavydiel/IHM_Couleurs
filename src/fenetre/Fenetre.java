package fenetre;

import java.awt.CardLayout;

import javax.swing.JFrame;

import couleurs.Palette;
import selection.EcranSelection;
import exportation.EcranExportation;


@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	private CardLayout cartes;
	private Palette palette;
	
	public Fenetre() {
		super("Selecteur de couleurs");
		cartes = new CardLayout();
		this.getContentPane().setLayout(cartes);
		setSize(1366, 768);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(new EcranSelection(this), "selection");
		this.getContentPane().add(new EcranExportation(this), "exportation");
		
		palette = new Palette(5);
		
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new Fenetre();
		fenetre.setVisible(true);
	}
	
	public void permuterEcran() {
		cartes.next(this.getContentPane());
	}
	
	public Palette getPalette() {
		return palette;
	}
}
