package Project;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class SearchPage extends JPanel {
	
	
	
	
	public  SearchPage(){
		
		//spilt the screen into Project.SearchPage.SearchPage().splitInHalves
		JPanel splitInHalves = new JPanel();              
		splitInHalves.setLayout(new GridLayout(1, 2));
		
		// beginning of the code that makes left half the panel
		JPanel leftHalf = new JPanel();
		leftHalf.setLayout(new BorderLayout());
		
		// beginning of the code that makes the search bar
		JTextField searchBox = new JTextField();
		searchBox.setColumns(16);
		JLabel searchBoxLabel = new JLabel ("Stock Search");
		JButton searchButton = new JButton("Search");

		JPanel searchComponentsCombine = new JPanel();
		searchComponentsCombine.setLayout(new FlowLayout());
		searchComponentsCombine.add( searchBoxLabel);
		searchComponentsCombine.add( searchBox);
		searchComponentsCombine.add( searchButton);
		leftHalf.add(searchComponentsCombine, BorderLayout.NORTH);
		// end of the code that makes the search bar
		
		// beginning of the code that makes the result panel
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
		
		
		for (int i = 0; i < 25; i++) {	
			JButton stockButton= new JButton("Stock - " + i) {
				{
				 setSize(400, 200);
		         setMaximumSize(getSize());
				}
			};
			resultPanel.add(stockButton);
		}
		
		
		JScrollPane scrollPane = new JScrollPane(resultPanel);
		scrollPane.setPreferredSize(new Dimension(100, 400));
		
		leftHalf.add(scrollPane, BorderLayout.CENTER);
		// end of the code that makes the result panel
		
		JButton previousButton = new JButton("Previous");
		JButton nextButton = new JButton("Next");
		
		// End of that makes the left 
		
		//this add the halves together
		splitInHalves.add(leftHalf);
		splitInHalves.add(new JLabel("Right half "));
		this.add(splitInHalves , BorderLayout.CENTER);
		
		
		
		searchButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		

	 }
	}

// Split panel into borders, east and west
//split each border into three sections 
