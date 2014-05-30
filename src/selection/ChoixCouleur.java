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
	private static Color CouleurActuelle;

	public ChoixCouleur(final JPanel fenetre) {
		super();
		this.parent = fenetre;
		Box horizontalBox = Box.createHorizontalBox();
		JPanel couleur = new JPanel();
		couleur.setLayout(new BoxLayout(couleur,BoxLayout.X_AXIS));	
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

		JLabel nbCouleurs = new JLabel("Nombres de couleurs : " +getPalette().getTaille()+"\n");
		add(nbCouleurs);

		for(int i=0; i<getPalette().getTaille();i++) {
			Color choix = getPalette().getGLCouleur(i).getColor();

			JPanel color = new JPanel();
			horizontalBox.add(Box.createGlue());
			color.setBackground(choix);
			color.setPreferredSize(new Dimension(50,50));
			color.setMaximumSize(new Dimension(50,50));
			horizontalBox.add(Box.createGlue());
			horizontalBox.add(color);
			horizontalBox.add(Box.createGlue());

			color.addMouseListener(	new MouseListener() {
				public void mouseClicked(MouseEvent e) {((EcranSelection) parent).permuterCarte();}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e){}
				
			});

			//add(new Couleurs(getPalette().getGLCouleur(i)));
		}

		add(horizontalBox);

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