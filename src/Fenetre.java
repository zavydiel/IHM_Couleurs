import javax.swing.JFrame;


public class Fenetre extends JFrame {

	public Fenetre() {
		super("Selecteur de couleurs");
		setSize(1286, 768);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane();
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new Fenetre();
		//fenetre.pack();
		fenetre.setVisible(true);
	}
}
