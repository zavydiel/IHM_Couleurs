import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ChoixCouleur extends JPanel{
	
	JFrame parent;
	
	public ChoixCouleur(JFrame parent) {
		super();
		this.parent = parent;
		add(new JButton("toto"));
	}
}
