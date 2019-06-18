package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Metier.Bateau;
import Metier.Partie;

public class GrilleBataille extends JPanel{
	private JPanel grille;
	private CaseGrille mesBoutons[][] = new CaseGrille[10][10];

	public GrilleBataille(Partie partie) {
		Font font = new Font("Century Gothic",Font.BOLD,20);

		grille = new JPanel();
		grille.setLayout(new GridLayout(11,11));

		int taille = 0, lettre = 65, numero = 1;

		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {

				if(i==0&&j==0) {
					JLabel entete = new JLabel();
					entete.setBackground(Color.BLACK);
					grille.add(entete);
				}

				if(i==0&&j!=0) {
					JLabel entete = new JLabel(""+(char)lettre);
					//entete.setBackground(Color.black);
					entete.setForeground(Color.black);
					grille.add(entete);
					lettre++;
				}


				if(j==0&&i!=0) {
					JLabel entete = new JLabel(""+numero);
					//entete.setBackground(Color.black);
					entete.setForeground(Color.black);
					grille.add(entete);
					numero++;
				}

				if(i>0&&j>0) {
					CaseGrille casePlateau = new CaseGrille(partie,i-1,j-1);
					casePlateau.setBackground(Color.blue);
					casePlateau.setBorder(BorderFactory.createEtchedBorder(Color.GRAY,Color.WHITE));
					grille.add(casePlateau);
					mesBoutons[i-1][j-1] = casePlateau;
				}
			}
		}
		this.setLayout(new BorderLayout());

		this.add(grille, BorderLayout.CENTER);
	}

	public void addBateau(Bateau bateau) {
		bateau.setGrilleBateau(this);
	}


	public CaseGrille[][] getPlateau() {
		return this.mesBoutons;
	}
	
	public void effacerGrille() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				mesBoutons[i][j].colorierCase(Color.BLUE);
				
			}
		}
	}
}

