package exportation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import couleurs.GLCouleur;

public class PanelCouleur extends JPanel{
	GLCouleur color;

	public PanelCouleur(GLCouleur color, int i) {
		this.color = color;
		Box horizontalBox;
		horizontalBox = Box.createHorizontalBox();
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(1366,768));
		setMaximumSize(new Dimension(1366,768));
		
		horizontalBox.add(Box.createGlue());
		JLabel numCouleur = new JLabel("Couleur "+i);
		horizontalBox.add(numCouleur);
		horizontalBox.add(Box.createGlue());
		
		JLabel couleur= new JLabel(" ");
		couleur.setPreferredSize(new Dimension(100,50));
		couleur.setBackground(color.getColor());
		couleur.setOpaque(true);
		horizontalBox.add(couleur);
		horizontalBox.add(Box.createGlue());
		
		JLabel rouge = new JLabel("R : ");
		TextField red = new TextField(""+color.getRed());
		red.setPreferredSize(new Dimension(90,20));
		red.setMaximumSize(new Dimension(90,20));
		red.setEditable(false);
		horizontalBox.add(rouge);
		horizontalBox.add(red);
		horizontalBox.add(Box.createGlue());
		
		JLabel vert = new JLabel("V : ");
		TextField green = new TextField(""+color.getGreen());
		green.setPreferredSize(new Dimension(90,20));
		green.setMaximumSize(new Dimension(90,20));		
		green.setEditable(false);
		horizontalBox.add(vert);
		horizontalBox.add(green);
		horizontalBox.add(Box.createGlue());
		  
		JLabel bleu = new JLabel("B : ");
		TextField blue = new TextField(""+color.getBlue());
		blue.setPreferredSize(new Dimension(90,20));
		blue.setMaximumSize(new Dimension(90,20));
		blue.setEditable(false);
		horizontalBox.add(bleu);
		horizontalBox.add(blue);
		horizontalBox.add(Box.createGlue());
		
		JLabel hexadecimal = new JLabel("Hex : ");
		TextField Hexa = new TextField(color.getHexa());
		Hexa.setPreferredSize(new Dimension(90,20));
		Hexa.setMaximumSize(new Dimension(90,20));		
		Hexa.setEditable(false);
		horizontalBox.add(hexadecimal);
		horizontalBox.add(Hexa);
		horizontalBox.add(Box.createGlue());
		horizontalBox.add(Box.createGlue());
		horizontalBox.add(Box.createGlue());

		add(horizontalBox);
		
		
		


	}

	/*public void paintComponent(Graphics g) {
		g.setColor(new Color(color.getRed(),color.getGreen(),color.getBlue()));
		g.fillRect(50,50,50,50);
	}*/
	
	
}