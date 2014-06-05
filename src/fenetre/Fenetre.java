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
	private EcranExportation export;
	
	public Fenetre() {
		super("Selecteur de couleurs");
		palette = new CouleursContainer(10);
		palette.setNombre(5);
		cartes = new CardLayout();
		
		export = new EcranExportation(this);
		
		this.getContentPane().setLayout(cartes);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(new EcranSelection(this), "selection");
		this.getContentPane().add(export, "exportation");		
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new Fenetre();
		fenetre.setVisible(true);
	}
	
	public void permuterEcran() {
		export.mettreAJour();
		cartes.next(this.getContentPane());
	}
	
	public CouleursContainer getPalette() {
		return palette;
	}
}
