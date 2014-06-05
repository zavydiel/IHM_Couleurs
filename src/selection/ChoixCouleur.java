package selection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import couleurs.CouleursContainer;
import couleurs.Palette;
import fenetre.Fenetre;


public class ChoixCouleur extends JPanel{

	protected JPanel parent;
	private int  CouleurActuelle;
	private Box horizontalBox;
	JLabel nbCouleurs;

	public ChoixCouleur(final JPanel fenetre) {
		super();
		this.parent = fenetre;
		horizontalBox = Box.createHorizontalBox();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		horizontalBox.setPreferredSize(new Dimension(1366, 80));
		
		
		
		nbCouleurs = new JLabel("Nombres de couleurs : ");
		//add(nbCouleurs);		
		
		Box infoBarre = new Box(BoxLayout.X_AXIS);
		infoBarre.setPreferredSize(new Dimension(600, 30));
		infoBarre.setMaximumSize(new Dimension(600, 30));
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(5, 3, 10, 1));
		spinner.setMaximumSize(new Dimension(42, 20));
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				getPalette().setNombre((int) ((JSpinner) e.getSource()).getValue());
				repaint();
			}
		});
		infoBarre.add(nbCouleurs);
		infoBarre.add(spinner);

		
		
		add(infoBarre);
		add(horizontalBox);
		repaint();
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
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		horizontalBox.removeAll();
		//this.setBackground(Palette.getCouleurAleatoire(200).getColor());
		
		//System.out.println("toto");
		
		horizontalBox.add(Box.createHorizontalGlue());
		for(int i=0; i<getPalette().getTaille();i++) {
			horizontalBox.add(new BoutonCouleur(i, this));
			horizontalBox.add(Box.createHorizontalGlue());
			//System.out.println("toto");
		}
		
		horizontalBox.revalidate();
		((EcranSelection) parent).actualiserApercu();
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