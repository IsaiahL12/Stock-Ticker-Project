/*
package Project;

import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;h
//import java.io.File;
//import java.io.IOException;
import java.text.ParseException;

//import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")
public class Display1 extends JFrame {
	public static JFrame frame;
	
	public static final int MINI_BORDER_X= 300;
	public static final int MINI_BORDER_Y= 300;
	public static final int MAX_BORDER_X = 800;
	
	public static final int MAX_BORDER_Y = 550;
	//dsa
	public static void main (String[] args) throws ParseException {
		frame = new Display1();
		
		frame.add(new SearchPage());
		//frame.add(new LandingPage());
		//frame.add(new PortfolioPage());
		frame.setMinimumSize(new Dimension(MINI_BORDER_X, MINI_BORDER_Y));
		frame.setMaximumSize(new Dimension(MAX_BORDER_X, MAX_BORDER_Y));
		//frame.pack(); // scale thing down so that every thing fits on the frame
		frame.setSize(MAX_BORDER_X, MAX_BORDER_Y);
		frame.setTitle("STOCK TICKER");
		frame.setLocationRelativeTo(null);  //Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
			
	 }
}
*/


package Project;

import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;h
//import java.io.File;
//import java.io.IOException;
import java.awt.event.ActionListener;

//import javax.imageio.ImageIO;
import javax.swing.*;

import org.w3c.dom.events.Event;

import com.orsoncharts.util.json.parser.ParseException;


@SuppressWarnings("serial")
public class Display1 extends JFrame {
	public static JFrame frame;
	public static JButton jbSearch = new JButton("Search");
	public static JButton jbPortfolio = new JButton("Portfolio"); 
	public static CardLayout cardLayout = new CardLayout(); 
	public static JPanel cardDeck = new JPanel();
	public static JPanel card1 = new LandingPage(cardLayout, cardDeck);
	public static JPanel card2 = new SearchPage(cardLayout, cardDeck);
	public static JPanel card3 = new PortfolioPage(cardLayout, cardDeck);
	
	public static final int MINI_BORDER_X= 300;
	public static final int MINI_BORDER_Y= 300;
	public static final int MAX_BORDER_X = 800;
	public static final int MAX_BORDER_Y = 550;
	
	public Display1(){
		
		this.setContentPane(cardDeck); 
		/*
		searchpage = new JButton ("Search");
		portfoliopage = new JButton ("Portfolio"); 
		*/
		//actionListener al = new actionListener(); 
		/*
		jbSearch.addActionListener(al); 
		jbPortfolio.addActionListener((al));  
		
		card1.add(jbSearch);
		card1.add(jbPortfolio);
		*/
		
		/*
		card1.add(searchpage); 
		card1.add(portfoliopage); 
		card2.add(portfoliopage); 
		card3.add(searchpage); 
		*/
		
		//card1.setLayout(cardLayout);
		cardDeck.setLayout(cardLayout);
		cardDeck.add(card1, "landing");
		cardDeck.add(card2, "search");
		cardDeck.add(card3, "portfolio");
//		card1.add(card2,"card2"); 
//		card1.add(card3, "card3"); 
		
		
		
		cardLayout.show(cardDeck, "card1");
		
	
			
	 }
	public class actionListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JButton src = (JButton) event.getSource(); 
			
			if(src.equals(jbSearch))
				cardLayout.show(card1, "card2");
			if(src.equals(jbPortfolio))
				cardLayout.show(card1, "card3");
		}
		
		
		
	}
	
	public static void main (String[] args){
		
		Display1 frame = new Display1(); 
	
		//frame.add(new SearchPage()); 
		//frame.add(new LandingPage());
		//frame.pack(); // scale thing down so that every thing fits on the frame
		frame.setSize(MAX_BORDER_X, MAX_BORDER_Y);
		frame.setTitle("STOCK TICKER");
		frame.setLocationRelativeTo(null);  //Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	 
		
		
}
} 
 
