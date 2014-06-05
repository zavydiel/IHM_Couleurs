package exportation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import couleurs.GLCouleur;

public class PanelCouleur extends JPanel{

	private GLCouleur color;
	
	private final Dimension dim = new Dimension(70, 20);

	public PanelCouleur(GLCouleur color, int i) {
		this.color = color;
		Box horizontalBox;
		
		Color couleurContraste = (color.getGrayLevel() < 142 ? Color.WHITE : Color.BLACK);
		
		horizontalBox = Box.createHorizontalBox();
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(1366,50));
		setMaximumSize(new Dimension(1366,50));
		setBackground(color.getGrayedColor());

		horizontalBox.add(Box.createGlue());
		JLabel numCouleur = new JLabel("Couleur " + formatter(i, 2));
		numCouleur.setForeground(couleurContraste);
		numCouleur.setPreferredSize(new Dimension(100, 20));
		numCouleur.setMaximumSize(new Dimension(100, 20));
		horizontalBox.add(numCouleur);
		horizontalBox.add(Box.createGlue());

		JLabel couleur= new JLabel(" ");
		couleur.setPreferredSize(dim);
		couleur.setMaximumSize(dim);
		couleur.setBackground(color.getColor());
		couleur.setOpaque(true);
		couleur.setBorder(BorderFactory.createLineBorder(couleurContraste));
		horizontalBox.add(couleur);
		horizontalBox.add(Box.createGlue());

		JLabel rouge = new JLabel("R : ");
		JTextField red = new JTextField(formatter(color.getRed(), 3));
		red.setPreferredSize(dim);
		red.setMaximumSize(dim);
		red.setEditable(false);
		horizontalBox.add(rouge);
		horizontalBox.add(red);
		horizontalBox.add(Box.createGlue());

		JLabel vert = new JLabel("V : ");
		JTextField green = new JTextField(formatter(color.getGreen(), 3));
		green.setPreferredSize(dim);
		green.setMaximumSize(dim);		
		green.setEditable(false);
		horizontalBox.add(vert);
		horizontalBox.add(green);
		horizontalBox.add(Box.createGlue());

		JLabel bleu = new JLabel("B : ");
		JTextField blue = new JTextField(formatter(color.getBlue(), 3));
		blue.setPreferredSize(dim);
		blue.setMaximumSize(dim);
		blue.setEditable(false);
		horizontalBox.add(bleu);
		horizontalBox.add(blue);
		horizontalBox.add(Box.createGlue());

		JLabel hexadecimal = new JLabel("Hex : ");
		JTextField Hexa = new JTextField(color.getHexa());
		Hexa.setPreferredSize(dim);
		Hexa.setMaximumSize(dim);		
		Hexa.setEditable(false);
		horizontalBox.add(hexadecimal);
		horizontalBox.add(Hexa);
		horizontalBox.add(Box.createGlue());
		horizontalBox.add(Box.createGlue());
		horizontalBox.add(Box.createGlue());

		add(horizontalBox);
	}
	
	private String formatter(int nombre, int longueur) {
		String s = "" + nombre;
		while (longueur - s.length() > 0) {
			s = "0" + s;
		}
		return s;
	}
}