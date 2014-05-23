package couleurs;

public class Palette {
	
	private GLCouleur[] couleurs;
	
	public Palette(int nombre) {
		couleurs  = new GLCouleur[nombre];
		for (int i = 0; i < getTaille(); i++) {
			int grayLevel = 20 + (255-20)/getTaille() * i;
			couleurs[i] = new GLCouleur(grayLevel);
		}
	}
	
	public GLCouleur getGLCouleur(int index) {
		return couleurs[index];
	}
	
	public int getTaille() {
		return couleurs.length;
	}
	
//	public void ordonnerNiveauGris() {
//		Collections.sort(couleurs, new CouleursComparator());
//	}
	
	
}
