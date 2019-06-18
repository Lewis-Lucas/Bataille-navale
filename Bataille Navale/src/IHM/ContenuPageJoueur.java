package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Metier.Partie;

public class ContenuPageJoueur extends JPanel{
	private GrilleBataille grille;
	private InfoJoueur infoJoueur;
	private BasPageJoueur basPageJoueur;
	private JPanel pan = new JPanel();
	private JButton valider;
	private PageJoueur jframe;

	public ContenuPageJoueur(Partie partie, PageJoueur jframe) {
		this.jframe = jframe;

		Font font = new Font("Century Gothic",Font.BOLD,30);

		grille = new GrilleBataille(partie); 
		infoJoueur = new InfoJoueur(partie); 
		basPageJoueur = new BasPageJoueur(partie);

		this.valider = new JButton("Valider");
		this.valider.setBackground(Color.WHITE);
		this.valider.setFont(font);

		this.valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(partie.getNumBateauAPlace() ==  partie.getBateauAPlace().length) {

					grille.effacerGrille();

					if (partie.isaJ1Joue()) {
						partie.setJ1aPlaceBateau(true);
						partie.setNumBateauAPlace(0);
						partie.setaJ1Joue(!partie.isaJ1Joue());
						partie.setJeu1(new Jeu(partie, jframe, grille));
						jframe.changeContent(new ContenuPageJoueur(partie, jframe));
					}
					else {
						partie.setJ2aPlaceBateau(true);
						partie.setaJ1Joue(!partie.isaJ1Joue());
						partie.setJeu2(new Jeu(partie, jframe, grille));
						jframe.changeContent(partie.getJeu1());
					}

				}

			}
		});

		JPanel jpBouton = new JPanel();
		jpBouton.add(this.valider);

		if(partie.isaJ1Joue()) {
			partie.setGrilleJ1(grille);

		}
		else {
			partie.setGrilleJ2(grille);

		}


		pan.add(grille);

		this.setLayout(new BorderLayout());

		this.add(jpBouton, BorderLayout.EAST);
		this.add(infoJoueur, BorderLayout.NORTH);
		this.add(pan,BorderLayout.CENTER);
		this.add(basPageJoueur,BorderLayout.SOUTH);
	}


}
