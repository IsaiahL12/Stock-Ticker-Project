package Project;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;


public class SearchPage extends JPanel {
	private JLabel jlblTitle = new JLabel ("Restuarant Finder :)");
	public  SearchPage(){
	/*	
	JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new Button("Okay"), BorderLayout.SOUTH);
    
	JPanel main = new JPanel();
	main.setLayout(new GridLayout(4, 1)); 
	main.add(new JLabel("Name"));
	main.add(new JLabel("Address"));
	main.add(new JLabel("State"));
	main.add(new JLabel("City"));
	add(main, BorderLayout.WEST);
		*/
	JPanel title = new JPanel();
	title.add(jlblTitle);
	this.add(title , BorderLayout.NORTH);
	
	 }
}

// Split panel into borders, east and west
//split each border into three sections 
