package Metier;

import IHM.ContenuPageParametre;
import IHM.GrilleBataille;
import IHM.Jeu;

public class Partie {
	
	private final Bateau[] bateauDispo =  new Bateau[4];
	private int numBateauAPlace;
	private final Bateau[] bateauAPlace;
	private GrilleBataille grilleJ1;
	private GrilleBataille grilleJ2;
	
	private Jeu jeu1;
	private Jeu jeu2;
	
	
	private boolean aJ1Joue;
	private String nomJoueur1;
	private String nomJoueur2;
	
	private String jlCommentaire;
	private boolean bateauPlace;
	
	private boolean joueur1AJoue;
	private boolean joueur2AJoue;
	
	private boolean J1aPlaceBateau;
	private boolean J2aPlaceBateau;
	
	private int scoreJ1;
	private int scoreJ2;
	
	private int scoreTouche;
	private int scoreGagne;

	private int etat;
	
	public Partie() {
		this.bateauDispo[0] = new Bateau("porte-avion", 5);
		this.bateauDispo[1] = new Bateau("croiseur", 4);
		this.bateauDispo[2] = new Bateau("contre-torpileur", 3);
		this.bateauDispo[3] = new Bateau("torpileur", 2);
		
		this.bateauAPlace = this.getBateauDispo();
		
		this.numBateauAPlace = 0;
		this.aJ1Joue = true;
		this.bateauPlace = false;
		
		this.joueur1AJoue = false;
		this.joueur2AJoue = false;
		this.etat = 0;
		
		this.J1aPlaceBateau = false;
		this.J2aPlaceBateau = false;
		
		this.scoreTouche = 0;
	}

	public boolean isJoueur1AJoue() {
		return joueur1AJoue;
	}

	public void setJoueur1AJoue(boolean joueur1aJoue) {
		joueur1AJoue = joueur1aJoue;
	}

	public boolean isJoueur2AJoue() {
		return joueur2AJoue;
	}

	public void setJoueur2AJoue(boolean joueur2aJoue) {
		joueur2AJoue = joueur2aJoue;
	}

	public boolean isJ1aPlaceBateau() {
		return J1aPlaceBateau;
	}

	public void setJ1aPlaceBateau(boolean j1aPlaceBateau) {
		J1aPlaceBateau = j1aPlaceBateau;
		this.setEtat(1);
	}

	public boolean isJ2aPlaceBateau() {
		return J2aPlaceBateau;
	}

	public void setJ2aPlaceBateau(boolean j2aPlaceBateau) {
		J2aPlaceBateau = j2aPlaceBateau;
		this.setEtat(1);
	}

	public boolean isBateauPlace() {
		return bateauPlace;
	}

	public void setBateauPlace(boolean bateauPlace) {
		this.bateauPlace = bateauPlace;
	}

	public Bateau[] getBateauDispo() {
		return bateauDispo;
	}

	public int getNumBateauAPlace() {
		return numBateauAPlace;
	}

	public void setNumBateauAPlace(int numBateauAPlace) {
		this.numBateauAPlace = numBateauAPlace;
	}

	public Bateau[] getBateauAPlace() {
		return bateauAPlace;
	}

	public GrilleBataille getGrilleJ1() {
		return grilleJ1;
	}

	public GrilleBataille getGrilleJ2() {
		return grilleJ2;
	}

	public void setGrilleJ1(GrilleBataille grilleJ1) {
		this.grilleJ1 = grilleJ1;
		addBateauToGrille(grilleJ1);
	}

	public void setGrilleJ2(GrilleBataille grilleJ2) {
		this.grilleJ2 = grilleJ2;
		addBateauToGrille(grilleJ2);
	}
	
	public void addBateauToGrille(GrilleBataille grille) {
		
		for(int i = 0; i < this.bateauAPlace.length; i++) {
			grille.addBateau(this.bateauDispo[i]);
		}
		
	}

	public boolean isaJ1Joue() {
		return aJ1Joue;
	}

	public void setaJ1Joue(boolean aJ1Joue) {
		this.aJ1Joue = aJ1Joue;
	}

	public String getNomJoueur1() {
		return nomJoueur1;
	}

	public void setNomJoueur1(String nomJoueur1) {
		this.nomJoueur1 = nomJoueur1;
	}

	public String getNomJoueur2() {
		return nomJoueur2;
	}

	public void setNomJoueur2(String nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}
	
	public Jeu getJeuCourantInverse() {
		if(this.isaJ1Joue()) {
			return this.jeu1;
		}
		else {
			return this.jeu2;
		}
	}
	
	public String getJoueurCourantInverse() {
		if(this.isaJ1Joue()) {
			return this.nomJoueur2;
		}
		else {
			return this.nomJoueur1;
		}
	}
	
	public String getJlCommentaire() {
		return jlCommentaire;
	}

	public void setJlCommentaire(String jlCommentaire) {
		this.jlCommentaire = jlCommentaire;
	}
	
	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		if(etat == 1 && this.J1aPlaceBateau && this.J2aPlaceBateau) {
			this.etat = etat;
		}
	}

	public Jeu getJeu1() {
		return jeu1;
	}

	public void setJeu1(Jeu jeu1) {
		this.jeu1 = jeu1;
	}

	public Jeu getJeu2() {
		return jeu2;
	}

	public void setJeu2(Jeu jeu2) {
		this.jeu2 = jeu2;
	}

	public int getScoreJ1() {
		return scoreJ1;
	}

	public void setScoreJ1(int scoreJ1) {
		this.scoreJ1 = scoreJ1;
	}

	public int getScoreJ2() {
		return scoreJ2;
	}

	public void setScoreJ2(int scoreJ2) {
		this.scoreJ2 = scoreJ2;
	}
	public int getScoreTouche() {
		return scoreTouche;
	}

	public void setScoreTouche(int scoreTouche) {
		this.scoreTouche = scoreTouche;
	}

	public int getScoreGagne() {
		return scoreGagne;
	}

	public void setScoreGagne(int scoreGagne) {
		this.scoreGagne = scoreGagne;
	}
	
	
	
	
	
}
