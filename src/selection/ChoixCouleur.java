package selection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import couleurs.CouleursContainer;
import fenetre.Fenetre;


public class ChoixCouleur extends JPanel{

	protected JPanel parent;
	private int  CouleurActuelle;

	public ChoixCouleur(final JPanel fenetre) {
		super();
		this.parent = fenetre;
		Box horizontalBox = Box.createHorizontalBox();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		horizontalBox.setPreferredSize(new Dimension(1366, 80));
		
		JLabel nbCouleurs = new JLabel("Nombres de couleurs : " +getPalette().getTaille()+"\n");
		add(nbCouleurs);
		horizontalBox.add(Box.createHorizontalGlue());

		for(int i=0; i<getPalette().getTaille();i++) {
			horizontalBox.add(new BoutonCouleur(i, this));
			horizontalBox.add(Box.createHorizontalGlue());
		}

		add(horizontalBox);

	}

		
	public CouleursContainer getPalette() {
		return ((EcranSelection) parent).getPalette();
	}
	
	public void setCouleurActuelle(int i) {
		((EcranSelection) parent).setCouleurActuelle(i);
	}
	
	public void permuterCarte() {
		((EcranSelection) parent).permuterCarte();
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