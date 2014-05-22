package couleurs;

import java.awt.Color;

public class GLCouleur extends Color {

	public GLCouleur(int r, int g, int b) {
		super(r, g, b);
	}
	
	public int getGrayLevel() {
		return (int) (0.3 * getRed() + 0.59 * getGreen() + 0.11 * getBlue());
	}

}
