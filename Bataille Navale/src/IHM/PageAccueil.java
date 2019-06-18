package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class PageAccueil extends JFrame implements ActionListener{
	private ImagePageAccueil fondPageAccueil = new ImagePageAccueil();
	private JButton jb;
	
	public PageAccueil() {
		//Creation JFrame
		this.setTitle("Bataille Navale");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(1200, 750);
		this.setResizable(false);
		//Creation des composants
		
		this.jb = new JButton("JOUER");
		this.jb.setBackground(Color.WHITE);
		Font font = new Font("Century Gothic",Font.BOLD,30);
		jb.setFont(font);
		this.jb.setBounds(525,650,150,40);
	
		//ajout des composants
		
		//placement des composants
		fondPageAccueil.setLayout(null);
		fondPageAccueil.add(jb);
		
		setContentPane(fondPageAccueil);
		jb.addActionListener(this);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		PageParametre test = new PageParametre();
		this.dispose();
	}
	
}
