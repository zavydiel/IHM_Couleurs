package couleurs;

import java.awt.Color;

public class GLCouleur {

	private Color couleur;
	
	public GLCouleur(int r, int g, int b) {
		couleur = new Color(r, g, b);
	}
	
	public int getGrayLevel() {
		return (int) (0.3 * getRed() + 0.59 * getGreen() + 0.11 * getBlue());
	}
	
	public int getRed() {
		return couleur.getRed();
	}
	
	public int getGreen()  {
		return couleur.getBlue();
	}
	
	public int getBlue() {
		return couleur.getBlue();
	}
	
	public Color getColor()  {
		return couleur;
	}
}
