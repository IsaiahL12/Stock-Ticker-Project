package Project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.JSONException;

import Project.SearchPage.Listener;



@SuppressWarnings("serial")
public class PortfolioPage extends JPanel {
	
	 
	 private JLabel titleLabel = new JLabel("Portfolio Page");
	 private JLabel PageName = new JLabel("payOff");
	 private double userMoney;
	 public CardLayout cardLayout;
	 public JPanel cardDeck;
	 public Records records;
	 public ScrollPane scrollpane;
	 public JPanel scrollPanel;
	 
	 public void searching() throws ParseException, JarException {
			
			try {
				scrollPanel.removeAll();
				JPanel options = new JPanel();
				options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
				
				
				for (int i = 0; i < records.getStockNumber(); i++) {	
					JButton stockButton= new JButton(records.getStockName(i)) {
						{
							
							Dimension d = new Dimension(367, 75);
				            setMinimumSize(d);
				            setMaximumSize(d);
				            setPreferredSize(d);
						}
					};
					stockButton.addActionListener(new Listener());
					// insert actions here
				}
				
				JScrollPane scrollPane = new JScrollPane(options);
				scrollPane.setPreferredSize(new Dimension(385, 385));
				scrollPanel.add(scrollPane);
				scrollPanel.invalidate();
				scrollPanel.validate();
				scrollPanel.repaint();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} 
	 
	 
	 
	public PortfolioPage(CardLayout clin, JPanel cardPanelin){
		
	cardLayout = clin;
	cardDeck = cardPanelin;
		
	JPanel leftPart = new JPanel();
	JPanel rightPart = new JPanel();
	JPanel splitInHalves = new JPanel();              
	splitInHalves.setLayout(new GridLayout(1, 2));
	
	
	
	
	// make a title of the left part
	 /* JPanel title = new JPanel();
	  title.setLayout(new FlowLayout());
	  title.add(pageName);
	  leftPart.add(title, BorderLayout.NORTH);*/
	  
	  //create the Portfolio Box
	  JPanel PortfolioBox = new JPanel();
	  scrollPane.setPreferredSize(new Dimension(285, 385));
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
}
