package selection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import sun.security.krb5.internal.PAEncTSEnc;
import couleurs.CouleursContainer;
import couleurs.GLCouleur;
import couleurs.Palette;


public class ModifCouleur extends JPanel {
	private JPanel parent;
	private Color couleur;
	private JLabel lab = new JLabel();
	private JPanel scrolled = new JPanel();
	private JScrollPane scroll;
	
	private final int COTE_COULEUR = 75;
	private final Dimension DIMENSION_PANEL = new Dimension(750, 200);

	public ModifCouleur(JPanel parent) {
		super();
		this.parent = parent;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//Box container = Box.createVerticalBox();
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		scroll = new JScrollPane(scrolled);
		scroll.setPreferredSize(DIMENSION_PANEL);
		scroll.setMaximumSize(DIMENSION_PANEL);
		//scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//scrolled.setLayout(new FlowLayout());
		scrolled.setMaximumSize(DIMENSION_PANEL);
		scrolled.setBackground(Color.WHITE);
		scrolled.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					Robot robby = new Robot();
					Color choix = robby.getPixelColor(e.getXOnScreen(), e.getYOnScreen());
					if (!choix.equals(Color.white)) {
						getPalette().setCouleur(new GLCouleur(choix), getIndexActuel());
						permuterCarte();
					}
				} catch(Exception ex) {
					System.out.println("Oh mince une erreur est survenue!");
				}
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e)  {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		JButton retour = new JButton("retour");
		retour.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				permuterCarte();
			}
		});
		
		container.add(Box.createVerticalGlue());
		container.add(scroll);
		container.add(Box.createVerticalGlue());
		container.add(retour);
		container.add(Box.createVerticalGlue());
		
		container.setAlignmentX(CENTER_ALIGNMENT);
		container.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.add(Box.createHorizontalGlue());
		this.add(container);
		this.add(Box.createHorizontalGlue());
	}
	
	public void mettreAJour() {
		ArrayList<GLCouleur> couleurs = Palette.getListeDeCouleurs(getCouleurActuelle().getGrayLevel());
		scrolled.removeAll();
		int ligne = (int) DIMENSION_PANEL.getWidth() / COTE_COULEUR - 1;
		//System.out.println(ligne);
		scrolled.setLayout(new GridLayout(couleurs.size() / ligne + 1, ligne));
		lab.setText(""+ getIndexActuel());
		
		//scrolled.getGraphics().drawImage(dessinerCouleurs(couleurs), 0, 0, null);
		scrolled.repaint();
		for (GLCouleur c : couleurs) {
			JPanel couleurPanel = new JPanel();
			couleurPanel.setMinimumSize(new Dimension(COTE_COULEUR, COTE_COULEUR));
			couleurPanel.setBackground(c.getColor());
			couleurPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			
			scrolled.add(couleurPanel);
			//System.out.println(c.getHexa());
		}
	}
	
//	private Image dessinerCouleurs(ArrayList<GLCouleur> couleurs) {
//		Image img = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
//		Graphics g = img.getGraphics();
//		int i = 0;
//		
//		int espace =  ((int) DIMENSION_PANEL.getWidth() % COTE_COULEUR) / (ligne + 1);
//		for (GLCouleur c : couleurs) {
//			int x = i % ligne;
//			int y = i / ligne;
//			
//			g.setColor(c.getColor());
//			g.fillRect(espace + (COTE_COULEUR + espace) * x, espace + (COTE_COULEUR + espace) * y,
//					COTE_COULEUR, COTE_COULEUR);
//		}
//		
//		return img;
//	}
	
	public CouleursContainer getPalette() {
		return ((EcranSelection) parent).getPalette();
	}
	
	public void setCouleurActuelle(int i) {
		((EcranSelection) parent).setCouleurActuelle(i);
	}
	
	public void permuterCarte() {
		((EcranSelection) parent).permuterCarte();
	}
	
	public int getIndexActuel() {
		return ((EcranSelection) parent).getIndexActuel();
	}
	
	public GLCouleur getCouleurActuelle() {
		return getPalette().getGLCouleur(getIndexActuel());
	}
}
