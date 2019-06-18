package IHM;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Metier.Partie;

public class InfoJoueur extends JPanel{
	private JLabel jlNom;
	private JLabel monLabel; 
	private JLabel jlTour;
	private ImageIcon monIcone;

	public InfoJoueur(Partie partie) {
		Font font = new Font("Century Gothic",Font.BOLD,30);

		monLabel = new JLabel(); 
		monIcone = new ImageIcon("Images/marin2.jpg" ); 
		monLabel.setIcon(monIcone);

		if(partie.isaJ1Joue()) {
			this.jlNom = new JLabel(partie.getNomJoueur1());
		} else {
			this.jlNom = new JLabel(partie.getNomJoueur2());
		}

		this.jlNom.setFont(font);

		JPanel jpJoueur = new JPanel();
		jpJoueur.add(this.monLabel);
		jpJoueur.add(this.jlNom);

		this.jlTour = new JLabel("Tour :");
		jlTour.setFont(font);


		//placement des composants
		this.setLayout(new BorderLayout());
		this.monLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.jlNom.setHorizontalAlignment(SwingConstants.CENTER);


		this.add(jpJoueur,BorderLayout.CENTER);
		this.add(jlTour,BorderLayout.WEST);
	}
}
