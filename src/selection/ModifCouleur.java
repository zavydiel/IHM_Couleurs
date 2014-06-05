package selection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import couleurs.CouleursContainer;
import couleurs.GLCouleur;
import couleurs.Palette;


public class ModifCouleur extends JPanel {
	private JPanel parent;
	private Color couleur;
	private JLabel lab = new JLabel();
	private JPanel scrolled = new JPanel();
	private JScrollPane scroll;
	private JSpinner spinner;
	
	private final int COTE_COULEUR = 50;
	private final Dimension DIMENSION_PANEL = new Dimension(600, 200);

	public ModifCouleur(JPanel parent) {
		super();
		this.parent = parent;
		this.setLayout(new GridBagLayout());
		
		//Box container = Box.createVerticalBox();
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));		
		container.setAlignmentX(CENTER_ALIGNMENT);
		
		scroll = new JScrollPane(scrolled);
		scroll.setPreferredSize(DIMENSION_PANEL);
		scroll.setMaximumSize(DIMENSION_PANEL);
		scroll.setAlignmentX(CENTER_ALIGNMENT);
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
						setCouleur(new GLCouleur(choix), getIndexActuel());
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
		
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				permuterCarte();
			}
		});
		retour.setAlignmentX(CENTER_ALIGNMENT);
		
		JTextField input = new JTextField("#XXXXXX");
		input.setMaximumSize(new Dimension(80, 20));
		input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String hex =((JTextField) e.getSource()).getText();
				if (hex.matches("^#[A-Fa-f0-9]{6}$")) { 
					((JTextField) e.getSource()).setText("#XXXXXX");
					setCouleur(new GLCouleur(hex), getIndexActuel());
				}
			}
		});		
		input.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	            ((JTextComponent) e.getSource()).setText("");
	        }
			public void focusLost(FocusEvent arg0) {}			
		});
		
		container.add(Box.createVerticalGlue());
		container.add(scroll);
		container.add(Box.createVerticalGlue());
		container.add(input);
		container.add(Box.createVerticalGlue());
		container.add(retour);
		container.add(Box.createVerticalGlue());
		
		this.add(container, new GridBagConstraints());
	}
	
	public void mettreAJour() {
		ArrayList<GLCouleur> couleurs = Palette.getListeDeCouleurs(getCouleurActuelle().getGrayLevel());
		scrolled.removeAll();
		int ligne = (int) DIMENSION_PANEL.getWidth() / COTE_COULEUR - 1;
		//System.out.println(ligne);
		scrolled.setLayout(new GridLayout(couleurs.size() / ligne + 1, ligne));
		lab.setText(""+ getIndexActuel());
		
		//scrolled.getGraphics().drawImage(dessinerCouleurs(couleurs), 0, 0, null);
		scrolled.invalidate();
		for (GLCouleur c : couleurs) {
			JPanel couleurPanel = new JPanel();
			couleurPanel.setMinimumSize(new Dimension(COTE_COULEUR, COTE_COULEUR));
			couleurPanel.setBackground(c.getColor());
			couleurPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			
			scrolled.add(couleurPanel);
			//System.out.println(c.getHexa());
		}
		scrolled.revalidate();
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
	
	public void setCouleur(GLCouleur c, int index) {
		getPalette().setCouleur(c, index);
		permuterCarte();
	}
}
