package exportation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import couleurs.GLCouleur;
import couleurs.CouleursContainer;
import fenetre.Fenetre;


public class EcranExportation extends JPanel {
	JFrame fenetre;
	JPanel panel1;
	JPanel panel2;

	public EcranExportation(JFrame parent) {
		super();
		this.fenetre = parent;

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for(int j=1;j<=getPalette().getTaille();j++) {
			add(new PanelCouleur(getPalette().getGLCouleur(j-1),j));
		}


		JButton Retour = new JButton("Retour");

		Retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				((Fenetre) fenetre).permuterEcran();

			}
		});

		add(Retour);
	}



	public CouleursContainer getPalette() {
		return ((Fenetre) fenetre).getPalette();
	}


}
