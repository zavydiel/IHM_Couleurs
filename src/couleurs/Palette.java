package couleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Palette {
	
	//HashSet<GLCouleur> couleurs = new HashSet<GLCouleur>();
	
	private static HashMap<Integer, HashSet<GLCouleur>> map = new HashMap<Integer, HashSet<GLCouleur>>();
	
	public Palette() {
	
		
	}
	
	private static void ajouterCouleurs(int a, int b, int gray, HashSet<GLCouleur> set) {
		// a -> red, b -> green
		int blue = Math.round((gray - 0.3f * a - 0.59f * b)/0.11f);
		//a -> red, b -> blue
		int green = Math.round((gray - 0.3f * a - 0.11f * b)/0.59f);
		//a -> blue, b-> green
		int red = Math.round((gray - 0.11f * a - 0.59f * b)/0.3f);
		ArrayList<GLCouleur> liste = new ArrayList<GLCouleur>();
		
		if (blue < 255 && blue > 0) liste.add(new GLCouleur(a, b, blue));
		if (green < 255 && green > 0) liste.add(new GLCouleur(a, green, b));
		if (red < 255 && red > 0) liste.add(new GLCouleur(red, b, a));
		
		for (GLCouleur c : liste) {
			if (c.getGrayLevel() == gray) set.add(c);
		}
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
		for (int a = 0; a < 256; a += 4) {
			for(int b = 0; b < 256; b += 4) {
				ajouterCouleurs(a, b, grayLevel, set);
			}
		}
		map.put(grayLevel, set);
		System.out.println(set.size() + "couleurs generees en" + (System.currentTimeMillis() - time) + " ms");
		/*Iterator<GLCouleur> it = set.iterator();
		GLCouleur etalon = it.next();

		while(it.hasNext()) {
			System.out.println("--");
			if (etalon.equals(it.next())) System.out.println("doublon");
		}*/
	}
	
	public static ArrayList<GLCouleur> getListeDeCouleurs(int grayLevel) {
		if(!map.containsKey(grayLevel)) genererListe(grayLevel);
		return new ArrayList<GLCouleur>(map.get(grayLevel));
	}
}
