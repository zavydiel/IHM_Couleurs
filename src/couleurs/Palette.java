package couleurs;


public class Palette {
	
	private GLCouleur[] couleurs;
	
	public Palette(int nombre) {
		couleurs  = new GLCouleur[nombre];
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
