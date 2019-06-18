package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;

import Metier.Partie;

public class ContenuPageParametre extends JPanel {

	private JLabel jl_parametre;
	private JLabel jl_commentaire;
	private JLabel jl_joueur1;
	private JLabel jl_joueur2;
	private static JTextField jtf_joueur1;
	private static JTextField jtf_joueur2;
	private JLabel jl_scoreTouche;
	private JLabel jl_scoreGagne;
	private static JTextField jtf_scoreTouche;
	private static JTextField jtf_scoreGagne;

	private JButton jb_regle;
	private JButton jb_debut;
	private JLabel jl_erreur;
	private Partie partie;
	
	private JLabel jl_scoreJ1;
	private JLabel jl_scoreJ2;

	public ContenuPageParametre() {


		Font font = new Font("Century Gothic",Font.BOLD,20);
		Font font2 = new Font("Century Gothic", Font.BOLD, 22);

		this.partie = new Partie();

		this.jl_parametre = new JLabel("Paramètre de la partie :");
		jl_parametre.setFont(font);
		this.jl_joueur1 = new JLabel("Joueur 1 :");
		jl_joueur1.setFont(font);
		this.jl_joueur2 = new JLabel("Joueur 2 :");
		jl_joueur2.setFont(font);
		this.jtf_joueur1 = new JTextField("");
		jtf_joueur1.setFont(font);
		this.jtf_joueur2 = new JTextField("");
		jtf_joueur2.setFont(font);
		this.jl_scoreTouche = new JLabel("Score touché :");
		jl_scoreTouche.setFont(font);

		this.jl_scoreGagne = new JLabel("Score pour gagné :");
		jl_scoreGagne.setFont(font);
		this.jtf_scoreTouche = new JTextField("");
		jtf_scoreTouche.setFont(font);
		this.jtf_scoreGagne = new JTextField("");
		jtf_scoreGagne.setFont(font);
		this.jb_debut = new JButton("DEBUT");
		jb_debut.setFont(font);
		

		this.jl_erreur = new JLabel("");
		this.jl_erreur.setForeground(Color.RED);
		jl_erreur.setFont(font2);

		this.jb_regle = new JButton("Règles");
		jb_regle.setFont(new Font("Century Gothic",Font.BOLD,30));






		this.setLayout(null);


		this.jl_parametre.setBounds(300,40,250,40);
		this.jl_joueur1.setBounds(282,100,100,40);
		this.jtf_joueur1.setBounds(400,100,150,40);
		this.jl_joueur2.setBounds(282,150,100,40);
		this.jtf_joueur2.setBounds(400,150, 150, 40);
		this.jl_scoreTouche.setBounds(235,200,200,40);
		this.jtf_scoreTouche.setBounds(400,200,150,40);
		this.jl_scoreGagne.setBounds(191,250,200,40);
		this.jtf_scoreGagne.setBounds(400,250,150,40);


		this.jb_regle.setBounds(650,350,150,60);
		this.jb_debut.setBounds(350,400,150,60);

		this.jl_erreur.setBounds(200,300, 400, 40);
		
	


		this.add(this.jl_parametre);
		this.add(this.jl_joueur1);
		this.add(this.jtf_joueur1);
		this.add(this.jl_joueur2);
		this.add(this.jtf_joueur2);
		this.add(this.jl_scoreTouche);
		this.add(this.jtf_scoreTouche);
		this.add(this.jl_scoreGagne);
		this.add(this.jtf_scoreGagne);


		this.add(this.jb_regle);

		this.add(this.jl_erreur);

		this.add(this.jb_debut);


		this.setVisible(true);


		jb_regle.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				exit();
				new PageRegle();

			}
		});

		jb_debut.addActionListener(new ActionListener( ) {
			@Override

			public void actionPerformed(ActionEvent arg0) {

				if(("").equals(jtf_joueur1.getText()) || ("").equals(jtf_joueur2.getText()) || ("").equals(jtf_scoreTouche.getText()) || ("").equals(jtf_scoreGagne.getText())) {

					jl_erreur.setText("Veuillez effectuer les bonnes saisies !");

				}
				else {
					if(!jtf_scoreTouche.getText().matches("[0-9]*") || !jtf_scoreGagne.getText().matches("[0-9]*")) {

						jl_erreur.setText("Veuillez effectuer les bonnes saisies !");

					}
					else {
						if(Integer.parseInt(jtf_scoreGagne.getText()) > Integer.parseInt(jtf_scoreTouche.getText())*14) {

							jl_erreur.setText("Veuillez effectuer les bonnes saisies !");
						} else {

							exit();
							partie.setNomJoueur1(jtf_joueur1.getText());
							partie.setNomJoueur2(jtf_joueur2.getText());
							partie.setScoreTouche(Integer.parseInt(jtf_scoreTouche.getText()));
							partie.setScoreGagne(Integer.parseInt(jtf_scoreGagne.getText()));
							new PageJoueur(partie);
						}
					}
				}

			}
		});

	}


	public static String getJtf_joueur1() {
		return jtf_joueur1.getText();
	}

	public static String getJtf_joueur2() {
		return jtf_joueur2.getText();
	}

	public static JTextField getJtf_scoreTouche() {
		return jtf_scoreTouche;
	}


	public static JTextField getJtf_scoreGagne() {
		return jtf_scoreGagne;
	}





	public void exit() {
		SwingUtilities.windowForComponent(this).dispose();
	}


}
