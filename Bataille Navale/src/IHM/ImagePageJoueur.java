package IHM;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePageJoueur extends JPanel{
	
	public void paintComponent(Graphics g){
		try {
			Image img = ImageIO.read(new File("Images/marin2.jpg"));
			g.drawImage(img, 0, 0,50,50, this);
		} catch (IOException e) {
			e.printStackTrace();
		}                
	}  
}
