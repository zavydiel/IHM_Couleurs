package exportation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fenetre.Fenetre;


public class EcranExportation extends JPanel {
	JFrame fenetre;
	JPanel panel1;
	JPanel panel2;
	
	public EcranExportation(JFrame parent) {
		super();
		this.fenetre = parent;
		JButton Button1 = new JButton("Retour");
		
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		
		JLabel test1 = new JLabel("test");
		JLabel test2 = new JLabel("test2");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panel1.setAlignmentX(CENTER_ALIGNMENT);
		panel2.setAlignmentX(CENTER_ALIGNMENT);
		
		panel1.setLayout(new GridLayout(0,5));
		panel2.setLayout(null);
		
		
		panel1.add(test1);
		panel1.add(test2);
		panel2.add(Button1);
		
		this.add(panel1);
		this.add(panel2);
	}
}
