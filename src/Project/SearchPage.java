package Project;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

import org.json.JSONException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@SuppressWarnings("serial")
public class SearchPage extends JPanel {
	
	
	private JLabel pageName = new JLabel ("Search Page");
	public JTextField searchBox = new JTextField();
	public JPanel leftHalf = new JPanel();
	public JPanel rightside = new JPanel();
	public JPanel resultPanel = new JPanel();
	public JPanel graph = new JPanel();
	public IEX getData = new IEX();
	public JButton symbolButton;
	public JButton nameButton;
	public String nameOfData;
	public String name;
	public JButton dayButton;
	public JButton weekButton;
	public JButton monthButton;
	public JButton yearButton;
	//public Vector <Double> high;
	//public Vector <Double> low;
	public Vector <Double> avg;
	public Vector <String> theStockDataForDay;
	public Vector <String> time;
	public CardLayout cardLayout;
	public JPanel cardDeck;
	
	public void searching() throws ParseException, JSONException {
		
		try {
			resultPanel.removeAll();
			Vector<String> results = new Vector<String>(); 
			results= getData.chooseOne(searchBox.getText());
			JPanel options = new JPanel();
			options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
			
			
			for (int i = 0; i < results.size(); i++) {	
				JButton stockButton= new JButton(results.get(i)) {
					{
						
						Dimension d = new Dimension(367, 75);
			            setMinimumSize(d);
			            setMaximumSize(d);
			            setPreferredSize(d);
					}
				};
				stockButton.addActionListener(new Listener());
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
	
	public SearchPage(CardLayout clin, JPanel cardPanelin){
		
		cardLayout = clin;
		cardDeck = cardPanelin;
		
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
		
		// beginning of the code that makes the Name/Symbol buttons 
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		symbolButton = new JButton("Symbol");
		nameButton = new JButton("Name");
		bottom.add(symbolButton);
		bottom.add(nameButton);
		nameButton.setEnabled(false);
		leftHalf.add(bottom, BorderLayout.SOUTH);
		// End of that makes the Name/Symbol buttons 
		splitInHalves.add(leftHalf);
		// End of that makes the left
		
		//Begin of code that makes the right side/ half
		
		rightside = new JPanel();
	    rightside.setLayout(new BorderLayout());
	  
	    //Begin of code that makes the data Panel
	    JPanel datePanel = new JPanel();
		dayButton = new JButton("Day");
		weekButton = new JButton("1M");
		monthButton = new JButton("6M");
		yearButton = new JButton("Year");
	
		
	    datePanel.add(dayButton);
	    datePanel.add(weekButton);
	    datePanel.add(monthButton);
	    datePanel.add(yearButton);
	    
	    rightside.add(datePanel, BorderLayout.NORTH);
	    // End of that makes the data Panel
	    
	    //Begin of code that makes the Graphs
	   // JPanel graph = new JPanel();
	    DynamicDataDemo demo = new DynamicDataDemo();
        //demo.pack();
        demo.setVisible(true);
        graph.add(demo.graph2("Stock", new Vector<Double>(),  null));
        rightside.add(graph, BorderLayout.CENTER);
        dayButton.setEnabled(false);
		weekButton.setEnabled(false);
		monthButton.setEnabled(false);
		yearButton.setEnabled(false);
	    //rightside.add(new JLabel ("Insert graph"), BorderLayout.CENTER);
	    // End of that makes the data Panel
	    
	    //Begin of code that makes the Graphs of buy sell buttons
	    JPanel dealPanel = new JPanel();
	    JButton addButton = new JButton("<html> <center>Add to <br/> Insterested Stock</center></html>");
	    JButton buyButton = new JButton("Buy");
	    
	    dealPanel.add(addButton);
	    dealPanel.add(buyButton);
	    
	    rightside.add(dealPanel, BorderLayout.SOUTH);
	    // End of that makes the data Panel
	    
	    
	    splitInHalves.add(rightside);
	    // End of that makes the Right side/ half

		
	    //Make title
	    JPanel title = new JPanel();
	    title.setLayout(new GridLayout(1,3));
	    JPanel backSection = new JPanel();
	    backSection.setLayout(new FlowLayout());
	    //JPanel logoutSection = new JPanel();
	    JPanel pName = new JPanel();
	    pName.setLayout(new FlowLayout());
	   // logoutSection.setLayout(new FlowLayout());
	    JButton BackButton = new JButton("Back to Portfolio Page");
	    //JButton Logout = new JButton("Logout");
	    backSection.add(BackButton);
	   // logoutSection.add(Logout);
	    pName.add(pageName);
	    title.add(backSection);
	    title.add(pName);
	    title.add(new JPanel());
	 // End of the title

	    
	   //this add every thing  together 
	    JPanel completeTheJPanel = new JPanel();
	    completeTheJPanel.setLayout(new BorderLayout());
	    completeTheJPanel.add(title, BorderLayout.NORTH);
	    completeTheJPanel.add(splitInHalves , BorderLayout.CENTER);
		this.add(completeTheJPanel, BorderLayout.CENTER);
		
		

		
		//Action Listeners for Buttons
		
		searchButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
			//IEX a = new IEX(); 
			try {
				searching();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		symbolButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				getData.choose = 0;
				symbolButton.setEnabled(false);
				nameButton.setEnabled(true);
				try {
					searching();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		nameButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				getData.choose = 1;
				symbolButton.setEnabled(true);
				nameButton.setEnabled(false);
				try {
					searching();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		dayButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				IEX getDataOfStock = new IEX();
				//System.out.println(nameOfData);
				try {
					//high = getDataOfStock.jsonOfDataDayHigh(nameOfData);
					
					//low = getDataOfStock.jsonOfDataDayLow(nameOfData);
					//System.out.println(low);
					avg = getDataOfStock.jsonOfDataDayAvg(nameOfData);
					//time = getDataOfStock.jsonOfDataDayTime( getDataOfStock.usingNameToFindSymbolWithJSON(nameOfData));
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// JPanel graph = new JPanel();
				graph.removeAll();
				DynamicDataDemo chart = new DynamicDataDemo();
				
				dayButton.setEnabled(false);
				weekButton.setEnabled(true);
				monthButton.setEnabled(true);
				yearButton.setEnabled(true);
				//chart.DynamicDataDemo1(title, data).setVisible(true);
			    graph.add(chart.graph1(name, avg));
			    rightside.add(graph, BorderLayout.CENTER);
			    rightside.invalidate();
			    rightside.validate();
			    rightside.repaint();
				
			}
		});	
		
		weekButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				IEX getDataOfStock = new IEX();
				//System.out.println(nameOfData);
				try {
					avg = getDataOfStock.jsonOfDataDayM1(nameOfData);
					
					time = getDataOfStock.jsonOfDataDayTime(nameOfData,"1m");
					
					
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// JPanel graph = new JPanel();
				graph.removeAll();
				DynamicDataDemo chart = new DynamicDataDemo();
				
				dayButton.setEnabled(true);
				weekButton.setEnabled(false);
				monthButton.setEnabled(true);
				yearButton.setEnabled(true);
				//chart.DynamicDataDemo1(title, data).setVisible(true);
			    graph.add(chart.graph2(name,avg, time));
			    rightside.add(graph, BorderLayout.CENTER);
			    rightside.invalidate();
			    rightside.validate();
			    rightside.repaint();
				
			
				
			}
		});
		
		monthButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				IEX getDataOfStock = new IEX();
				//System.out.println(nameOfData);
				try {
					//high = getDataOfStock.jsonOfDataDayHigh(nameOfData);
					
					//low = getDataOfStock.jsonOfDataDayLow(nameOfData);
					//System.out.println(low);
					avg = getDataOfStock.jsonOfDataDayM6(nameOfData);
					time = getDataOfStock.jsonOfDataDayTime(nameOfData,"3m");
					//System.out.println(avg);
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// JPanel graph = new JPanel();
				graph.removeAll();
				DynamicDataDemo chart = new DynamicDataDemo();
				
				dayButton.setEnabled(true);
				weekButton.setEnabled(true);
				monthButton.setEnabled(false);
				yearButton.setEnabled(true);
				//chart.DynamicDataDemo1(title, data).setVisible(true);
			    graph.add(chart.graph2(name,avg, time));
			    rightside.add(graph, BorderLayout.CENTER);
			    rightside.invalidate();
			    rightside.validate();
			    rightside.repaint();	
				
			}
		});	
		
		yearButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				IEX getDataOfStock = new IEX();
				//System.out.println(nameOfData);
				try {
					//high = getDataOfStock.jsonOfDataDayHigh(nameOfData);
					
					//low = getDataOfStock.jsonOfDataDayLow(nameOfData);
					//System.out.println(low);
					avg = getDataOfStock.jsonOfDataDayY1(nameOfData);
					time = getDataOfStock.jsonOfDataDayTime(nameOfData,"1y");
					//System.out.println(avg);
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// JPanel graph = new JPanel();
				graph.removeAll();
				DynamicDataDemo chart = new DynamicDataDemo();
				
				dayButton.setEnabled(true);
				weekButton.setEnabled(true);
				monthButton.setEnabled(true);
				yearButton.setEnabled(false);
				
			    graph.add(chart.graph2(name,avg, time));
			    rightside.add(graph, BorderLayout.CENTER);
			    rightside.invalidate();
			    rightside.validate();
			    rightside.repaint();	
				
			}
		});	
		
		addButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				Vector <String> storeDataWrite = new  Vector <String> ();
				Vector <String> storeDataFinal = new  Vector <String> ();
				boolean noDuplicateCheck = true;
				String Data = "Data";
				String filepath = "Store_Data.txt";
				int saveIndex= 0 ;
				
				
				try {
					BufferedReader in = new BufferedReader(new FileReader(filepath));
					String str;
					while ((str = in.readLine()) != null) {
					    	storeDataWrite.add(str);
					    }
					in.close();
					for(int i =0; i<storeDataWrite.size(); i++) {
						 if(storeDataWrite.get(i)== "INTERESTED") {
							 i++;
							 saveIndex=i;
							 while(storeDataWrite.get(i)!= "END") {
								 if(storeDataWrite.get(i)== nameOfData) {
									JOptionPane.showMessageDialog(null, "You already have "+nameOfData+ " stock in your interested folder" , "Duplicate",JOptionPane.WARNING_MESSAGE);
									noDuplicateCheck =false;
								 }
								 i++;	 	 
							 }
						 }
					}
					if (noDuplicateCheck) {
						storeDataWrite.insertElementAt(nameOfData, saveIndex+2);
					}
					for(int i =0; i<storeDataWrite.size(); i++) {
						if(storeDataWrite.get(i)!= null) {
							storeDataFinal.add(storeDataWrite.get(i));
						}
					}
					FileWriter fw = new FileWriter (filepath, false);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					//System.out.println("A");
					for(int i =0; i<storeDataFinal.size(); i++) {
						pw.println(storeDataFinal.get(i));	
					}
					pw.flush();
					pw.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});	
		
		buyButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
		
				

				
			}
		});	
		
		BackButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardDeck, "portfolio");		
			}
		});	

		
		
	 }
	public class Listener implements ActionListener
    {
	public void actionPerformed(ActionEvent e) {
		IEX getDataOfStock = new IEX();
		String text= e.getSource().toString();
		String[] hold= text.split("text=");
		hold=hold[1].split(",");
		nameOfData= hold[0];
		name= hold[0];
		 avg= new Vector <Double>();
		
		
		if (getData.choose == 1) {
			try {
				nameOfData = getDataOfStock.usingNameToFindSymbolWithJSON(nameOfData);
				//time = getDataOfStock.jsonOfDataDayTime(nameOfData);
				//System.out.println(nameOfData);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		
		try {
			avg = getDataOfStock.jsonOfDataDayAvg(nameOfData);
			//time = getDataOfStock.jsonOfDataDayTime(nameOfData);
			} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// JPanel graph = new JPanel();
		graph.removeAll();
		DynamicDataDemo chart = new DynamicDataDemo();
		
		dayButton.setEnabled(false);
		weekButton.setEnabled(true);
		monthButton.setEnabled(true);
		yearButton.setEnabled(true);
		//chart.DynamicDataDemo1(title, data).setVisible(true);
	    graph.add(chart.graph1(hold[0], avg));
	    rightside.add(graph, BorderLayout.CENTER);
	    rightside.invalidate();
	    rightside.validate();
	    rightside.repaint();
	    
		}
    }
	}
