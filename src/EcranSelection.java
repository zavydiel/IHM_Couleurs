import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EcranSelection extends JPanel {
	
	Fenetre fenetre;
	
	public EcranSelection(Fenetre fenetre) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.fenetre = fenetre;
		this.add(new Apercu(fenetre));
		this.add(new CouleursCards(fenetre));		
	}
}
