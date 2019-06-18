package IHM;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Metier.Partie;

public class PageJoueur extends JFrame{

	public PageJoueur(Partie partie) {
		this.setTitle("Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 950);

		this.changeContent(new ContenuPageJoueur(partie, this));

		this.setVisible(true);
		//this.pack();
	}


	public void changeContent(JPanel newJpanel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(newJpanel);
		this.getContentPane().repaint();
		this.getContentPane().validate();
		
	}
}
