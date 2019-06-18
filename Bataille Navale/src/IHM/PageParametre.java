package IHM;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PageParametre extends JFrame {
	private JLabel jl_titre;
	private ContenuPageParametre cpp;
	
	public PageParametre() {
		this.setTitle("Bataille Navale");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(850, 550);
		Font font = new Font("Century Gothic",Font.BOLD,30);
		
		this.jl_titre = new JLabel("Bataille navale");
		jl_titre.setFont(font);
		this.jl_titre.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		this.cpp = new ContenuPageParametre();
		
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add(jl_titre, BorderLayout.NORTH);
		this.getContentPane().add(cpp, BorderLayout.CENTER);
		this.setVisible(true);
	}

}