package IHM;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Metier.Partie;

public class PageVictoire extends JFrame{

	private JLabel jl_victoire;
	
	public PageVictoire(Partie partie, String gagnant) {
		this.setTitle("Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		this.jl_victoire = new JLabel("Victoire de : " + gagnant);
		
		this.setLayout(null);
		
		this.jl_victoire.setBounds(100,100,300,80);

		this.add(this.jl_victoire);
		
		this.setVisible(true);
		
	}
}

