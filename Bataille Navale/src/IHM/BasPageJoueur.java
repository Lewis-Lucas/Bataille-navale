package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Metier.Partie;

public class BasPageJoueur extends JPanel {

	private JLabel jl_score;

	private JButton jbArreter;
	
public BasPageJoueur(Partie partie) {
	
		Font font = new Font("Century Gothic",Font.BOLD,30);
		
		this.jl_score = new JLabel("Score :");
		jl_score.setFont(font);

		
		this.jbArreter = new JButton("Arreter");
		this.jbArreter.setBackground(Color.WHITE);
		jbArreter.setFont(font);
		
		JPanel jpBouton = new JPanel();
		jpBouton.add(this.jbArreter);
		
		this.setLayout(new BorderLayout());
		
		this.add(jl_score, BorderLayout.WEST);
		this.add(jpBouton,BorderLayout.EAST);
	}

		


}
