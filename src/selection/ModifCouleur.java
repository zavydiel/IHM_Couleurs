package selection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import couleurs.CouleursContainer;
import couleurs.GLCouleur;
import couleurs.Palette;


public class ModifCouleur extends JPanel {
	JPanel parent;
	Color couleur;
	JLabel lab = new JLabel();
	JPanel scrolled = new JPanel();
	JScrollPane scroll = new JScrollPane();

	public ModifCouleur(JPanel parent) {
		super();
		this.parent = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//scroll.setLayout(new GridLayout(200, 6));
		scroll.setPreferredSize(new Dimension(750, 200));
		scroll.setMaximumSize(new Dimension(750, 200));
		
		scroll.add(new JLabel("toto"));
		scroll.add(scrolled);
		scrolled.add(new JLabel("scrolled"));
		this.add(lab);
		this.add(scrolled);
		JButton retour = new JButton("retour");
		retour.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				permuterCarte();
			}
		});
		this.add(retour);
		this.add(new JLabel("tototo"));
	}
	
	public void mettreAJour() {
		scrolled.removeAll();
		lab.setText(""+ ((EcranSelection) parent).getIndexActuel());
		ArrayList<GLCouleur> couleurs = Palette.getListeDeCouleurs(getCouleurActuelle().getGrayLevel());
		for (GLCouleur c : couleurs) {
			JPanel couleurPanel = new JPanel();
			couleurPanel.setMinimumSize(new Dimension(30, 30));
			couleurPanel.setBackground(c.getColor());
			scrolled.add(couleurPanel);
			System.out.println("toto");
		}	
	}
	
	public CouleursContainer getPalette() {
		return ((EcranSelection) parent).getPalette();
	}
	
	public void setCouleurActuelle(int i) {
		((EcranSelection) parent).setCouleurActuelle(i);
	}
	
	public void permuterCarte() {
		((EcranSelection) parent).permuterCarte();
	}
	
	public int getIndexActuel() {
		return ((EcranSelection) parent).getIndexActuel();
	}
	
	public GLCouleur getCouleurActuelle() {
		return getPalette().getGLCouleur(getIndexActuel());
	}
}
