package selection;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import couleurs.CouleursContainer;


public class ChoixCouleur extends JPanel{
	
	protected JPanel parent;
	
	public ChoixCouleur(JPanel fenetre) {
		super();
		this.parent = fenetre;
		
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		JLabel nbCouleurs = new JLabel("Nombres de couleurs : " +getPalette().getTaille()+"\n");
		add(nbCouleurs);
		
		for(int i=0; i<getPalette().getTaille();i++) {
		add(new Couleurs(getPalette().getGLCouleur(i)));
		}
		
	}
	
	public CouleursContainer getPalette() {
		return ((EcranSelection) parent).getPalette();
	}
}

/*JButton bouton = new JButton("toto");
bouton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		((EcranSelection) parent).permuterCarte();				
	}			
});
add(bouton);*/