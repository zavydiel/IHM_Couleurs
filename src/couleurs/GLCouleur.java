package couleurs;

import java.awt.Color;
import java.util.Random;

public class GLCouleur {

	private Color couleur;
	
	public GLCouleur(int r, int g, int b) {
		couleur = new Color(r, g, b);
	}
	
	public GLCouleur(Color c) {
		couleur = c;
	}
	
	public GLCouleur(String s) {
		couleur = Color.decode(s);
	}
	
	/*public GLCouleur(int grayLevel) {
		Random rng = new Random();
		float r = 0.3f * grayLevel;
		float g = 0.59f * grayLevel;
		float b = 0.11f * grayLevel;
		int gray = 0;
//		while(gray < grayLevel) {
//			int i = rng.nextInt(3);
//			if(i==0 && r<242) r += 1/0.3;
//			if(i==1 && g<242) g += 1/0.59;
//			if(i==2 && b<232) b += 1/0.11;
//			
//			gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
//		} 

		couleur = new Color((int) r,(int) g, (int) b);

		System.out.println(getGrayLevel() + ": " + r + ", "+ g +", " + b);
		
//		r = 42 + rng.nextInt(256 - 42);
//		g = 42 + rng.nextInt(256 - 42);
//		b = 42 + rng.nextInt(256 - 42);
//		gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
//		int diff = grayLevel - gray;
//		r += (int) (0.3*diff);
//		g += (int) (0.59*diff);
//		b += (int) (0.11*diff);
		
//		float teinte = 42; //(float) Math.random();
//		
//		this.couleur = Color.getHSBColor(teinte, 0.5f, .5f); //(float) (255/grayLevel));
//		r = couleur.getRed();
//		g = couleur.getGreen();
//		b = couleur.getBlue();
		
//		System.out.print(r + ", "+ g +", " + b + "(" + teinte + "/" + grayLevel +")");
		//System.out.print("delta= " + (((int) (0.3*diff)) + (int) (0.59*diff) + (int) (0.11*diff)));
		//couleur = new Color(r, g, b);

		System.out.println(" // " + getGrayLevel());		
	}*/
	
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
		return couleur.getGreen();
	}
	
	public int getBlue() {
		return couleur.getBlue();
	}
	
	public Color getColor()  {
		return couleur;
	}
	
	public String getHexa() {
		/*return "#" + Integer.toHexString(getRed()) 
				+Integer.toHexString(getGreen())
				+Integer.toHexString(getBlue());*/
		return String.format("#%02x%02x%02x", getRed(), getGreen(), getBlue());				
	}
	
	public boolean equals(GLCouleur c) {
		return this.getColor().equals(c.getColor());
	}
	
	public boolean isConflictuel(CouleursContainer container) {
		for (int i = 0; i < container.getTaille(); i++) {
			GLCouleur c = container.getGLCouleur(i);
			if (c != this && c.isConflictuel(this)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isConflictuel(GLCouleur c) {
		return Math.abs(c.getGrayLevel() - this.getGrayLevel()) < 12;
	}
}
