package Metier;
import java.awt.Color;

import IHM.CaseGrille;
import IHM.GrilleBataille;

public class Bateau {

	private String nom;
	private int longueur;
	private boolean place;
	private GrilleBataille grilleBateau;

	public Bateau(String nom, int longueur) {
		this.nom = nom;
		this.longueur = longueur;
	}

	public GrilleBataille getGrilleBateau() {
		return grilleBateau;
	}

	public void setGrilleBateau(GrilleBataille grilleBateau) {
		this.grilleBateau = grilleBateau;
	}

	public boolean isPlace() {
		return place;
	}

	public void setPlace(boolean place) {
		this.place = place;
	}

	public boolean placerBateau(CaseGrille caseVise) {
		if(caseVise.getCoordX()+this.longueur <= 10 && !chevaucherCase(caseVise)) {


			for(int i=0; i < this.longueur; i++) {
				this.grilleBateau.getPlateau()[caseVise.getCoordY()][caseVise.getCoordX()+i].colorierCase(Color.RED);
				this.grilleBateau.getPlateau()[caseVise.getCoordY()][caseVise.getCoordX()+i].setBateau(this);
			}
			return true;
		}
		else {
			return false;
		}
	}

	public boolean chevaucherCase(CaseGrille caseVise) {
		int numPartBat = 0;
		boolean chevauchement = false;

		while (!chevauchement && numPartBat < this.longueur) {
			if(this.grilleBateau.getPlateau()[caseVise.getCoordY()][caseVise.getCoordX()+numPartBat].estOccupe()) {
				chevauchement = true;
			} else {
				numPartBat++;
			}
		}

		return chevauchement;
		
	}

}
