package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Metier.Bateau;
import Metier.Partie;

public class CaseGrille extends JButton {

	private Bateau bateauCase;
	private Partie partie;
	private final int coordX;
	private final int coordY;


	public CaseGrille (Partie partie, int coordY, int coordX) {

		this.partie = partie;
		this.coordY = coordY;
		this.coordX = coordX;


		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("getEtat " + partie.getEtat());

				//Si on est en cour de placement de bateau
				if(partie.getEtat() == 0) {

					if(partie.getNumBateauAPlace() < partie.getBateauAPlace().length) {
						placeBateau(partie.getBateauAPlace()[partie.getNumBateauAPlace()]);
					}




				}

				//si on joue
				else  {
					if(partie.getEtat() == 1) {
						if(!partie.isJoueur1AJoue() && partie.isaJ1Joue()) {
							if(estOccupe()) {
								colorierCase(Color.RED);

								partie.setScoreJ1(partie.getScoreJ1() + partie.getScoreTouche());
								if(partie.getScoreGagne() == partie.getScoreJ1()) {
										new PageVictoire(partie, partie.getNomJoueur2());
								}
							}
							else {
								colorierCase(Color.GRAY);
							}
							partie.setJoueur1AJoue(true);
						}
						if(!partie.isJoueur2AJoue() && !partie.isaJ1Joue()) {
							if(estOccupe()) {
								colorierCase(Color.RED);
								partie.setScoreJ2(partie.getScoreJ2() + partie.getScoreTouche());
								if(partie.getScoreGagne() == partie.getScoreJ2()) {
									new PageVictoire(partie, partie.getNomJoueur1());
								}
							}
							else {
								colorierCase(Color.GRAY);
							}
							partie.setJoueur2AJoue(true);
						}
					}
				}

				System.out.println("getEtat" + partie.getEtat());

			}
		});
	}

	public void colorierCase(Color color) {
		this.setBackground(color);
	}

	public void setBateau(Bateau bateau) {
		this.bateauCase = bateau;
	}

	public boolean estOccupe() {
		return bateauCase != null;
	}

	public void placeBateau(Bateau bateauAPlace) {
		if(!this.estOccupe()) {
			if(bateauAPlace.placerBateau(this)) {
				this.partie.setNumBateauAPlace(partie.getNumBateauAPlace() + 1);
			}
		}
	}

	public int getCoordX() {
		return coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(60,60);
	}




}
