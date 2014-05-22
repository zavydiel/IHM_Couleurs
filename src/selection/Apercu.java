package selection;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import fenetre.Fenetre;

public class Apercu extends JPanel {
	protected JLabel apercu;
	private JFrame fenetre;
	
	public Apercu(JFrame parent) {
		super();
		this.fenetre = parent;
		setPreferredSize(new Dimension(900,500));
		Graphe graph = new Graphe();
		this.apercu = new JLabel("Apercu");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(apercu);
		add(graph);
		
		apercu.setAlignmentX(CENTER_ALIGNMENT);
		graph.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton bouton = new JButton("toto");
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				((Fenetre) fenetre).permuterEcran();
				
			}

			
		});
		add(bouton);
	}
	
	}
