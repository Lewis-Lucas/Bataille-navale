package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Metier.Partie;


public class Jeu extends JPanel{

	private InfoJoueur infoJoueur;
	private BasPageJoueur basPageJoueur;
	private JPanel pan = new JPanel();
	private JButton valider;
	private PageJoueur jframe;

	public Jeu(Partie partie, PageJoueur jframe, GrilleBataille grille) {
		this.jframe = jframe;

		Font font = new Font("Century Gothic",Font.BOLD,30);

		infoJoueur = new InfoJoueur(partie);
		basPageJoueur = new BasPageJoueur(partie);

		this.valider = new JButton("Valider");
		this.valider.setBackground(Color.WHITE);
		this.valider.setFont(font);

		this.valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(partie.isaJ1Joue()) {
					partie.setJoueur1AJoue(false);
					if(partie.getJeu1() == null) {
						partie.setJeu1(Jeu.this);
					}
					
				}
				else {
					partie.setJoueur2AJoue(false);
					if(partie.getJeu2() == null) {
						partie.setJeu2(Jeu.this);
					}
				}
					partie.setaJ1Joue(!partie.isaJ1Joue());
					jframe.changeContent(partie.getJeuCourantInverse());
				
			}
		});

		JPanel jpBouton = new JPanel();
		jpBouton.add(this.valider);

		pan.add(grille);

		this.setLayout(new BorderLayout());

		this.add(jpBouton, BorderLayout.EAST);
		this.add(infoJoueur, BorderLayout.NORTH);
		this.add(pan,BorderLayout.CENTER);
		this.add(basPageJoueur,BorderLayout.SOUTH);
	}
	
	

}
