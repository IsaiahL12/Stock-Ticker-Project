package Project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PortfolioPage extends JPanel {
	
	 
	 private JLabel pageName = new JLabel("Portfolio Page");
	 private JLabel PageName = new JLabel("payOff");
	
	public PortfolioPage(){
		
	JPanel leftPart = new JPanel();
	JPanel rightPart = new JPanel();
	JPanel splitInHalves = new JPanel();              
	splitInHalves.setLayout(new GridLayout(1, 2));
	
	
	
	
	// make a title of the left part
	  JPanel title = new JPanel();
	  title.setLayout(new FlowLayout());
	  title.add(pageName);
	  leftPart.add(title, BorderLayout.NORTH);
	/*  
	  //create the Portfolio Box
	  JPanel PortfolioBox = new JPanel();
	  JScrollPane scrollPane = new JScrollPane();
	  scrollPane.setPreferredSize(new Dimension(285, 385));
	  PortfolioBox.add(scrollPane);
	  leftPart.add(PortfolioBox, BorderLayout.CENTER);
	*/
	  
	  rightPart.setLayout(new GridLayout(2,1));
	  rightPart.setLayout(new BorderLayout());
	  
	  JPanel TITLE = new JPanel();
	  TITLE.add(PageName);
	  rightPart.add(TITLE, BorderLayout.NORTH);
	  
	  JPanel payOff = new JPanel();
	  payOff.setLayout(new GridLayout(3,1));// three parts at here, property, gain and loss today, total property change
	  rightPart.add(payOff);
	  
	
	splitInHalves.add(leftPart);
	splitInHalves.add(rightPart);
	this.add(splitInHalves, BorderLayout.CENTER);
	}
	
	/*
	 package Project;

public class PortfolioPage extends JPanel {
 private JPanel leftPart = new JPanel();
 private JPanel rightPart = new JPanel();
 private JLabel pageName = new JLabel("Portfolio Page");
 private JLabel PageName = new JLabel("payOff");
 public PortfolioPage(){
  this.setLayout(new BorderLayout());
  this.setLayout(new GridLayout(1,2));
  leftPart.setLayout(new BorderLayout());
  
  // make a title of the left part
  JPanel title = new JPanel();
  title.setLayout(new FlowLayout());
  title.add(pageName);
  leftPart.add(title, BorderLayout.NORTH);
  
  //create the Portfolio Box
  JPanel PortfolioBox = new JPanel();
  JScrollPane scrollPane = new JScrollPane();
  scrollPane.setPreferredSize(new Dimension(385, 385));
  PortfolioBox.add(scrollPane);
  leftPart.add(PortfolioBox, BorderLayout.CENTER);
  
  rightPart.setLayout(new GridLayout(2,1));
  rightPart.setLayout(new BorderLayout());
  
  JPanel TITLE = new JPanel();
  TITLE.add(PageName);
  rightPart.add(TITLE, BorderLayout.NORTH);
  
  JPanel payOff = new JPanel();
  payOff.setLayout(new GridLayout(3,1));// three parts at here, property, gain and loss today, total property change
  rightPart.add(payOff);
  
  
  
  this.add(leftPart);
  this.add(rightPart);
 } 
	 */
}
