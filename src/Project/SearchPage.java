package Project;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class SearchPage extends JPanel {
	
	
	
	private JLabel pageName = new JLabel ("Search Page");
	public JTextField searchBox = new JTextField();
	public JPanel leftHalf = new JPanel();
	public JPanel rightside = new JPanel();
	JPanel resultPanel = new JPanel();
	
	public  SearchPage(){
		
		//split the screen into Project.SearchPage.SearchPage().splitInHalves
		JPanel splitInHalves = new JPanel();              
		splitInHalves.setLayout(new GridLayout(1, 2));
		
		// beginning of the code that makes left half the panel
		leftHalf = new JPanel();
		leftHalf.setLayout(new BorderLayout());
		
		// beginning of the code that makes the search bar
		//JTextField searchBox = new JTextField();
		searchBox.setColumns(16);
		JLabel searchBoxLabel = new JLabel ("Stock Search");
		JButton searchButton = new JButton("Search");

		
		//Search Bar JPanel 
		JPanel searchComponentsCombine = new JPanel();
		searchComponentsCombine.setLayout(new FlowLayout());
		searchComponentsCombine.add(searchBoxLabel);
		searchComponentsCombine.add(searchBox);
		searchComponentsCombine.add(searchButton);
		leftHalf.add(searchComponentsCombine, BorderLayout.NORTH);
		// end of the code that makes the search bar
	
		// beginning of the code that makes the result panel
		//JPanel resultPanel = new JPanel();
		JPanel options = new JPanel();
		options.add(new JLabel("<html> Here is where the result of the search bar will be. <br/> Search for a stock!</html>"));
		
		JScrollPane scrollPane = new JScrollPane(options);
		scrollPane.setPreferredSize(new Dimension(385, 370));
		resultPanel.add(scrollPane);
		leftHalf.add(resultPanel, BorderLayout.CENTER);
		// end of the code that makes the result panel
		
		// beginning of the code that makes the next/Prev buttons 
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		JButton previousButton = new JButton("Previous");
		JButton nextButton = new JButton("Next");
		bottom.add(previousButton);
		bottom.add(nextButton);
		leftHalf.add(bottom, BorderLayout.SOUTH);
		// End of that makes the next/Prev buttons 
		splitInHalves.add(leftHalf);
		// End of that makes the left
		
		//Begin of code that makes the right side/ half
		
		rightside = new JPanel();
	    rightside.setLayout(new BorderLayout());
	  
	    //Begin of code that makes the data Panel
	    JPanel datePanel = new JPanel();
		JButton dayButton = new JButton("Day");
		JButton weekButton = new JButton("Week");
		JButton monthButton = new JButton("Month");
		JButton yearButton = new JButton("Year");
	
		
	    datePanel.add(dayButton);
	    datePanel.add(weekButton);
	    datePanel.add(monthButton);
	    datePanel.add(yearButton);
	    
	    rightside.add(datePanel, BorderLayout.NORTH);
	    // End of that makes the data Panel
	    
	    //Begin of code that makes the Graphs
	    JPanel graph = new JPanel();
	    DynamicDataDemo demo = new DynamicDataDemo("Dynamic Data Demo");
        //demo.pack();
        demo.setVisible(true);
        graph.add(demo);
        rightside.add(demo, BorderLayout.CENTER);
	    //rightside.add(new JLabel ("Insert graph"), BorderLayout.CENTER);
	    // End of that makes the data Panel
	    
	    //Begin of code that makes the Graphs of buy sell buttons
	    JPanel dealPanel = new JPanel();
	    JButton sellButton = new JButton("Sell");
	    JButton buyButton = new JButton("Buy");
	    
	    dealPanel.add(sellButton);
	    dealPanel.add(buyButton);
	    
	    rightside.add(dealPanel, BorderLayout.SOUTH);
	    // End of that makes the data Panel
	    
	    
	    splitInHalves.add(rightside);
	    // End of that makes the Right side/ half

		//this add the halves together
	    JPanel completeTheJPanel = new JPanel();
	    completeTheJPanel.setLayout(new BorderLayout());
	    JPanel title = new JPanel();
	    title.setLayout(new FlowLayout());
	    title.add(pageName);
	    completeTheJPanel.add(title, BorderLayout.NORTH);
	    completeTheJPanel.add(splitInHalves , BorderLayout.CENTER);
		this.add(completeTheJPanel, BorderLayout.CENTER);
		
		

		
		//Action Listeners for Buttons
		
		searchButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
			IEX a = new IEX(); 
			try {
				resultPanel.removeAll();
				
				//a.searchForByNames(searchBox.getText());
				Vector<String> results = new Vector<String>(); 
				results= a.searchForByNames(searchBox.getText());
				JPanel options = new JPanel();
				//options.removeAll();
				options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
				
				
				for (int i = 0; i < results.size(); i++) {	
					JButton stockButton= new JButton(results.get(i)) {
						{
							
							Dimension d = new Dimension(367, 75);
				            setMinimumSize(d);
				            setMaximumSize(d);
				            setPreferredSize(d);
				         /*  
						 setSize(400, 200);
				         setMaximumSize(getSize());
				          */
						}
					};
					options.add(stockButton);
				}
				
				JScrollPane scrollPane = new JScrollPane(options);
				scrollPane.setPreferredSize(new Dimension(385, 385));
				resultPanel.add(scrollPane);
				resultPanel.invalidate();
				resultPanel.validate();
				resultPanel.repaint();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		previousButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		nextButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				//yo
			}
		});
		
		dayButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
		
		weekButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		monthButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
		
		yearButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
		
		sellButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
		
		buyButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	

		
		
	 }
	}

