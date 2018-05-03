package Project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;
import java.util.jar.JarException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;

import Project.SearchPage.Listener;



@SuppressWarnings("serial")
public class PortfolioPage extends JPanel {
private JPanel options = new JPanel();
private JPanel PortfolioBox = new JPanel();
private JLabel titleLabel = new JLabel("Portfolio Page");
private JLabel PageName = new JLabel("payOff");
private double userMoney;
public CardLayout cardLayout;
public JPanel cardDeck;
public Records records;

private JPanel leftPart = new JPanel();
private JPanel rightPart = new JPanel();
//private JPanel PortfolioBox = new JPanel();
//private JLabel pageName = new JLabel("Portfolio Page");
private double totalProperty = 250000;
private double totalGain = -998.25;
private double totalPercentage;
private double dailyPercentage;


private DynamicDataDemo portfolioGraph; 

public PortfolioPage(CardLayout clin, JPanel cardPanelin){
cardLayout = clin;
cardDeck = cardPanelin;
this.setLayout(new BorderLayout());
this.setLayout(new GridLayout(1,2));
leftPart.setLayout(new BorderLayout());
  
JPanel splitInHalves = new JPanel();              
splitInHalves.setLayout(new GridLayout(1, 2));

  
  rightPart.setLayout(new GridLayout(2,1));
  rightPart.setLayout(new BorderLayout());
  
  try {
	  Vector <String> writeDataAsAButton = new  Vector <String> ();
  PortfolioBox.removeAll();
File file = new File("Store_Data.txt");
FileReader fileReader = new FileReader(file);
BufferedReader bufferedReader = new BufferedReader(fileReader);
options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
String line;
while ((line = bufferedReader.readLine()) != null) {
	writeDataAsAButton.add(line);
}

for (int i = 0; i < writeDataAsAButton.size(); i++) {	
	 if(writeDataAsAButton.get(i).equalsIgnoreCase("INTERESTED")) {
		 i=i+2;
		 //System.out.println("B");
		
		 while(!(writeDataAsAButton.get(i).equalsIgnoreCase("END")) ) {
				JButton stockButton= new JButton(writeDataAsAButton.get(i)) {
					{
						
						Dimension d = new Dimension(367, 75);
			            setMinimumSize(d);
			            setMaximumSize(d);
			            setPreferredSize(d);
					}
				};
				stockButton.addActionListener(new Listener());
				options.add(stockButton);
			 i++;	 	 
		 }
	 }

}
/*	
JButton stockbutton= new JButton(line.toString()) {
{
Dimension d = new Dimension(367, 75);
            setMinimumSize(d);
            setMaximumSize(d);
            setPreferredSize(d);
}
};
stockbutton.addActionListener(new Listener());
options.add(stockbutton);
stockbutton.addActionListener(new ActionListener() { 
  public void actionPerformed(ActionEvent e) { 
  
  } 
} );
}*/
fileReader.close();
} catch (IOException e) {
e.printStackTrace();
}
  
  JScrollPane scrollPane = new JScrollPane(options);
  scrollPane.setPreferredSize(new Dimension(385, 385));
  PortfolioBox.add(scrollPane);
  leftPart.add(PortfolioBox, BorderLayout.CENTER);
  
  JButton InterestedButton= new JButton("Interested");
  JButton BuyButton= new JButton("Buy");
  JPanel topLeftPart= new JPanel();
  topLeftPart.setLayout(new FlowLayout());
  topLeftPart.add(InterestedButton);
  topLeftPart.add(BuyButton);
  leftPart.add(topLeftPart, BorderLayout.NORTH);
  
  JButton sellButton= new JButton("Sell");
  JButton restartButton= new JButton("Restart");
  JPanel bottomLeftPart= new JPanel();
  bottomLeftPart.setLayout(new FlowLayout());
  bottomLeftPart.add(InterestedButton);
  bottomLeftPart.add(BuyButton);
  leftPart.add(bottomLeftPart, BorderLayout.SOUTH);
  
//create the Portfolio Box
   PortfolioBox = new JPanel();
  
  scrollPane.setPreferredSize(new Dimension(385, 385));
  PortfolioBox.add(scrollPane);
  leftPart.add(PortfolioBox, BorderLayout.CENTER);
  
  
 
  
  rightPart.setLayout(new GridLayout(2,1));
  //rightPart.setLayout(new BorderLayout());
  
  totalPercentage = (totalProperty + totalGain) / totalProperty; 
  Vector<Double> vec = new Vector<Double>();
  vec.add(250000.45);
  vec.add(250523.23);
  vec.add(250347.9);
  vec.add(250790.89);
  vec.add(250113.67); 
  vec.add(249789.34);
  vec.add(249467.12);
  vec.add(249231.47);
  vec.add(249001.75); 
  JPanel payOff = new JPanel();
  payOff.setLayout(new GridLayout(3,1));// three parts at here, property, gain and loss today, total property change
  
  
  JPanel propertyGraph = new JPanel();
  JPanel HoldingPanel = new JPanel();
  portfolioGraph = new DynamicDataDemo(); 
  //propertyGraph.add(new JPanel()); 
  HoldingPanel.add(portfolioGraph.graph1("Portfolio Overview", vec));   
  HoldingPanel.setLayout(new GridLayout(1,1)); 
  propertyGraph.add(HoldingPanel);
  
 
  totalProperty += totalGain; 
 
 
  JPanel emptySpace = new JPanel(); 
  
  
  JLabel totalValue = new JLabel("total property:  " + totalProperty + "$");
  JLabel totalpercentage = new JLabel( totalPercentage+"%" );
  JLabel dailygain = new JLabel("total Gain:  " + totalGain );
 totalValue.setFont(new Font("Serif", Font.BOLD, 20));
  
  totalpercentage.setFont(new Font("Serif", Font.BOLD, 20));
  dailygain.setFont(new Font("Serif", Font.BOLD, 20));
  
  if(totalGain < 0) {
      totalpercentage.setForeground(Color.red);  
  }
  else if(totalGain > 0) {
      
      totalpercentage.setForeground(Color.green);
  }
  
  payOff.add(totalValue);
  payOff.add(dailygain);
  payOff.add(totalpercentage);
  
  
  rightPart.add(payOff);
  rightPart.add(propertyGraph);
  
splitInHalves.add(leftPart);
splitInHalves.add(rightPart);
JPanel title = new JPanel();
    title.setLayout(new GridLayout(1,3));
    JPanel goToSearch = new JPanel();
    goToSearch.setLayout(new FlowLayout());
    JPanel gotoLogIn = new JPanel();
    gotoLogIn.setLayout(new FlowLayout());
    //JPanel logoutSection = new JPanel();
    JPanel pName = new JPanel();
    pName.setLayout(new FlowLayout());
   // logoutSection.setLayout(new FlowLayout());
    JButton goToSearchPageButton = new JButton("Go to Search Page");
    JButton goTheLogInButton = new JButton("Logout");
    //JButton Logout = new JButton("Logout");
    goToSearch.add(goToSearchPageButton);
    gotoLogIn.add(goTheLogInButton);
   // logoutSection.add(Logout);
    pName.add(titleLabel);
    title.add(gotoLogIn);
    title.add(pName);
    title.add(goToSearch);
    JPanel completeTheJPanel = new JPanel();
    completeTheJPanel.setLayout(new BorderLayout());
    completeTheJPanel.add(title, BorderLayout.NORTH);
    completeTheJPanel.add(splitInHalves , BorderLayout.CENTER);
this.add(completeTheJPanel, BorderLayout.CENTER);

goToSearchPageButton.addActionListener(new ActionListener(){ 
public void actionPerformed(ActionEvent e) {
cardLayout.show(cardDeck, "search");
}
});

goTheLogInButton.addActionListener(new ActionListener(){ 
public void actionPerformed(ActionEvent e) {
cardLayout.show(cardDeck, "landing");
}
});

InterestedButton.addActionListener(new ActionListener(){	
	public void actionPerformed(ActionEvent e) {
		PortfolioBox.removeAll(); 
		Vector <String> writeDataAsAButton = new  Vector <String> ();
		options = new  JPanel();
		try {
			 
		File file = new File("Store_Data.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			writeDataAsAButton.add(line);
		}

		for (int i = 0; i < writeDataAsAButton.size(); i++) {	
			 if(writeDataAsAButton.get(i).equalsIgnoreCase("INTERESTED")) {
				 i=i+2;
				 //System.out.println("B");
				
				 while(!(writeDataAsAButton.get(i).equalsIgnoreCase("END")) ) {
						JButton stockButton= new JButton(writeDataAsAButton.get(i)) {
							{
								
								Dimension d = new Dimension(367, 75);
					            setMinimumSize(d);
					            setMaximumSize(d);
					            setPreferredSize(d);
							}
						};
						stockButton.addActionListener(new Listener());
						options.add(stockButton);
					 i++;	 	 
				 }
			 }

		}
		/*	
		JButton stockbutton= new JButton(line.toString()) {
		{
		Dimension d = new Dimension(367, 75);
		            setMinimumSize(d);
		            setMaximumSize(d);
		            setPreferredSize(d);
		}
		};
		stockbutton.addActionListener(new Listener());
		options.add(stockbutton);
		stockbutton.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
		  
		  } 
		} );
		}*/
		fileReader.close();
		} catch (IOException e1) {
		e1.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane(options);
		scrollPane.setPreferredSize(new Dimension(385, 385));
		PortfolioBox.add(scrollPane);
		leftPart.add(PortfolioBox, BorderLayout.CENTER);
		leftPart.invalidate();
		leftPart.validate();
		leftPart.repaint();
	}
});	


}
public class Listener implements ActionListener
    {
public void actionPerformed(ActionEvent e) {
}
    }}