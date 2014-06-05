package selection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import couleurs.CouleursContainer;
import couleurs.GLCouleur;
	
public class BoutonCouleur extends JPanel{
	private ChoixCouleur parent;
	private int index;
	
	public BoutonCouleur(int i, ChoixCouleur parent) {
		this.parent = parent;
		this.index = i;		
		this.setPreferredSize(new Dimension(50,50));
		this.setMaximumSize(new Dimension(50,50));
		
		Color borderColor = (getCouleur().isConflictuel(getPalette()) ? Color.RED : Color.BLACK);
		
		this.setBorder(BorderFactory.createLineBorder(borderColor));;

		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				setCouleurActuelle();
				permuterCarte();
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e){}			
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(getCouleurRGB());
	}
	
	public Color getCouleurRGB() {
		return getPalette().getGLCouleur(index).getColor();
	}
	
	public GLCouleur getCouleur() {
		return getPalette().getGLCouleur(index);
	}
	
	public CouleursContainer getPalette() {
		return ((ChoixCouleur) parent).getPalette();
	}
	
	public void permuterCarte() {
		((ChoixCouleur) parent).permuterCarte();
	}
	
	public void setCouleurActuelle() {
		parent.setCouleurActuelle(index);
	}
}
