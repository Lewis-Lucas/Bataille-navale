package IHM;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PageRegle extends JFrame implements ActionListener{
	
	private JLabel titre;
	private JLabel nbr_bat;
	private JButton jb_retour;
	
	public PageRegle() {
		
		this.setTitle("Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(600, 750);
		this.setResizable(false);
		
		Font font = new Font("Century Gothic",Font.BOLD,20);
		Font font2 = new Font("Century Gothic",Font.BOLD,16);
		
		this.setLayout(null);

		this.titre = new JLabel("Règle de la bataille navale :");
		this.titre.setBounds(170,10,400,40);
		this.titre.setFont(font);
		
		this.nbr_bat = new JLabel("<html> <a>-Limitation de 3 bateaux par type de bateau pour chaque joueur <br><br> -Les bateaux ne peuvent être que positionner horizontalement <br><br> - Cliquer sur la case de la grille pour tirer <br><br> -Eliminer tous les bateaux ennemis pour gagner ou gagner le nombre de point requis <br><br> - Quand la case est rouge vous avez touché <br><br> -Quand la case est grise vous avez raté</a> </html> ");
		this.nbr_bat.setBounds(10,10,600,400);
		this.nbr_bat.setFont(font2);
		
		
		
		this.jb_retour = new JButton("Retour");
		this.jb_retour.setBounds(385,665,200,50);
		this.jb_retour.setFont(font);
		jb_retour.addActionListener(this);


		
		this.add(this.nbr_bat);
		this.add(this.titre);
		
		this.add(this.jb_retour);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		PageParametre test = new PageParametre();
		this.dispose();
	}
}
