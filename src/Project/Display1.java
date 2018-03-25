package Project;

import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;
import javax.swing.*;


public class Display1 extends JFrame {
	public static JFrame frame;
	
	public static final int MINI_BORDER_X= 300;
	public static final int MINI_BORDER_Y= 300;
	
	public static final int MAX_BORDER_X = 800;
	public static final int MAX_BORDER_Y = 500;
	
	public static void main (String[] args) {
		frame = new Display1();
		frame.add(new SearchPage());
		frame.setMinimumSize(new Dimension(MINI_BORDER_X, MINI_BORDER_Y));
		frame.setMaximumSize(new Dimension(MAX_BORDER_X, MAX_BORDER_Y));
		//frame.pack(); // scale thing down so that every thing fits on the frame
		frame.setSize(MAX_BORDER_X, MAX_BORDER_Y);
		frame.setTitle("STOCK TICKER :)");
		frame.setLocationRelativeTo(null);  //Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
			
	 }
}
