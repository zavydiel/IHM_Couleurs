package couleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Palette {
	
	//HashSet<GLCouleur> couleurs = new HashSet<GLCouleur>();
	
	private static HashMap<Integer, HashSet<GLCouleur>> map = new HashMap<Integer, HashSet<GLCouleur>>();
	
	public Palette() {
	
		
	}
	
	private static GLCouleur genererCouleur(int r, int g, int gray) {
		int b = (int) ((gray - 0.3 * r - 0.59 * g)/0.11);
		if (b > 255 || b < 0) return null ;
		//System.out.println(b);
		return new GLCouleur(r, g, b);
	}
	
	
	/**
	 * Recupere une couleur a partir d'un niveau de gris
	 * @param grayLevel
	 * @return une couleur aleatoire avec le niveau de gris demande
	 */
	public static GLCouleur getCouleurAleatoire(int grayLevel) {		
		return (GLCouleur) getListeDeCouleurs(grayLevel).get((int) (map.get(grayLevel).size() * Math.random()));
	}
	
	
	/**
	 * Génère et sauve la liste des couleurs correspondant a un niveau de gris passe en parametre
	 * @param grayLevel 
	 */
	private static void genererListe(int grayLevel) {
		HashSet<GLCouleur> set = new HashSet<GLCouleur>();		
		long time = System.currentTimeMillis();
		for (int r = 0; r < 256; r++) {
			for(int g = 0; g < 256; g++) {
				GLCouleur c = genererCouleur(r, g, grayLevel);
				if (c != null && c.getGrayLevel() == grayLevel) set.add(c);
			}
		}
		map.put(grayLevel, set);
		System.out.println(set.size() + "couleurs generees en" + (System.currentTimeMillis() - time) + " ms");
	}
	
	public static ArrayList<GLCouleur> getListeDeCouleurs(int grayLevel) {
		if(!map.containsKey(grayLevel)) genererListe(grayLevel);
		return new ArrayList<GLCouleur>(map.get(grayLevel));
	}
}
