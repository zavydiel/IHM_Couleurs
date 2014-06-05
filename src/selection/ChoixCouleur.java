package selection;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import couleurs.CouleursContainer;


public class ChoixCouleur extends JPanel{

	protected JPanel parent;
	private Box horizontalBox;
	JLabel nbCouleurs;

	public ChoixCouleur(final JPanel fenetre) {
		super();
		this.parent = fenetre;
		horizontalBox = Box.createHorizontalBox();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		horizontalBox.setPreferredSize(new Dimension(1366, 80));
		
		
		
		nbCouleurs = new JLabel("Nombres de couleurs : ");
		
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
		
		JLabel instruction = new JLabel();
		instruction.setFont(new Font("Helvetica", Font.ITALIC, 12));
		instruction.setText("Cliquer sur une couleur pour la modifier");
		infoBarre.add(nbCouleurs);
		infoBarre.add(spinner);
		infoBarre.add(Box.createHorizontalGlue());
		infoBarre.add(instruction);
		
		
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
		
		horizontalBox.add(Box.createHorizontalGlue());
		for(int i=0; i<getPalette().getTaille();i++) {
			horizontalBox.add(new BoutonCouleur(i, this));
			horizontalBox.add(Box.createHorizontalGlue());
		}
		
		horizontalBox.revalidate();
		((EcranSelection) parent).actualiserApercu();
	}
}