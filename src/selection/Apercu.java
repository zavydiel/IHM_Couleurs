package selection;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import couleurs.CouleursContainer;
import fenetre.Fenetre;

public class Apercu extends JPanel {
	 JFrame fenetre;
	
	public Apercu(JFrame parent) {
		super();
		this.fenetre = parent;
		Box HorizontalBox;
		HorizontalBox = Box.createHorizontalBox();
		setPreferredSize(new Dimension(1366,300));
		Graphe graph = new Graphe(fenetre);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		HorizontalBox.add(Box.createGlue());
		this.setBorder(BorderFactory.createTitledBorder("Apercu"));
		HorizontalBox.add(graph);
		HorizontalBox.add(Box.createGlue());
		add(HorizontalBox);
		
		JButton bouton = new JButton("Exportation");
		bouton.setAlignmentX(CENTER_ALIGNMENT);;
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				((Fenetre) fenetre).permuterEcran();
				
			}

			
		});

		add(bouton);
	}
	
	public CouleursContainer GetPalette() {
		return ((Fenetre) fenetre).getPalette();
	}
	
}
