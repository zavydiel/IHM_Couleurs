import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EcranSelection extends JPanel {
	
	JFrame fenetre;
	
	public EcranSelection(JFrame fenetre) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.fenetre = fenetre;
		this.add(new Apercu(fenetre));
		this.add(new CouleursCards(fenetre));		
	}
}
