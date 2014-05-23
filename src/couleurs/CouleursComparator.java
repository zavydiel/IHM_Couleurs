package couleurs;

import java.util.Comparator;

public class CouleursComparator implements Comparator<GLCouleur> {

	@Override
	public int compare(GLCouleur arg0, GLCouleur arg1) {
		if(arg0.getGrayLevel() == arg1.getGrayLevel()) {
			return 0;
		} else if(arg0.getGrayLevel() > arg1.getGrayLevel()) {
			return 1;
		}
		return -1;
	}

}
