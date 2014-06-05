package couleurs;

public class CouleursContainer {
	
	private GLCouleur[] couleurs;
	private int[] niveauxGris;
	
	private int taille;
	
	public final int NOMBRE_MAX = 10;
	
	public CouleursContainer(int taille) {
		this.taille= taille;
		couleurs  = new GLCouleur[NOMBRE_MAX];
		niveauxGris = new int[NOMBRE_MAX];
		for (int i = 0; i < getTaille() ; i++) {
			int grayLevel = 25 + (255-25)/NOMBRE_MAX * i;
			couleurs[i] = Palette.getCouleurAleatoire(grayLevel);
		}
	}
	
	public GLCouleur getGLCouleur(int index) {
		return couleurs[index];
	}
	
	public int getTaille() {
		return taille;
	}
	
//	public void ordonnerNiveauGris() {
//		Collections.sort(couleurs, new CouleursComparator());
//	}
	
	public void setCouleur(GLCouleur c, int i) {
		couleurs[i] = c;
	}
}
