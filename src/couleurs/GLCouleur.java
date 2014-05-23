package couleurs;

import java.awt.Color;
import java.util.Random;

public class GLCouleur {

	private Color couleur;
	
	public GLCouleur(int r, int g, int b) {
		couleur = new Color(r, g, b);
	}
	
	public GLCouleur(int grayLevel) {
		Random rng = new Random();
		int r = 0;
		int g = 0;
		int b = 0;
		int gray = 0;
		while(gray < grayLevel) {
			int i = rng.nextInt(3);
			if(i==0 && r<252) r++;
			if(i==1 && g<252) g++;
			if(i==2 && b<252) b++;
			
			gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
		}

		couleur = new Color(r, g, b);

		System.out.println(getGrayLevel() + ": " + r + ", "+ g +", " + b);
	}
	
	public int getGrayLevel() {
		return (int) (0.3 * getRed() + 0.59 * getGreen() + 0.11 * getBlue());
	}
	
	public Color getGrayedColor() {
		return new Color(getGrayLevel(), getGrayLevel(), getGrayLevel());
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
	
	public String getHexa() {
		return "#" + Integer.toHexString(getRed()) 
				+Integer.toHexString(getGreen())
				+Integer.toHexString(getBlue());
	}
}
