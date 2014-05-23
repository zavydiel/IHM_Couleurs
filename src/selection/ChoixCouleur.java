package selection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ChoixCouleur extends JPanel{
	
	protected JPanel parent;
	
	public ChoixCouleur(JPanel fenetre) {
		super();
		this.parent = fenetre;
		JButton bouton = new JButton("toto");
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				((EcranSelection) parent).permuterCarte();				
			}			
		});
		add(bouton);
	}
}
