package Project;
import java.util.*;
import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class LandingPage extends JPanel {
	
	private JLabel pageName = new JLabel("Landing Page");
	
	public LandingPage(){
		
		JPanel firstlayer = new JPanel();
		firstlayer.setLayout(new BorderLayout());
		
		//Note alterPassword is the JPanel where the new and old passwords are typed in.
		// changePassword is the JPanel with the button to trigger the panel swap.
		//Do not confuse the two.
		
		JPanel alterPassword = new JPanel();
		
		JPanel oldPassword = new JPanel();
		
		JTextField oldPasswordBox = new JTextField();
		oldPasswordBox.setColumns(16);
		JLabel oldPasswordLabel = new JLabel("Enter Old Password");
		
		oldPassword.add(oldPasswordLabel);
		oldPassword.add(oldPasswordBox);
		
		JPanel newPassword = new JPanel();
		
		JTextField newPasswordBox = new JTextField();
		newPasswordBox.setColumns(16);
		JLabel newPasswordLabel = new JLabel("Enter New Password");
		JButton newPasswordButton = new JButton("Confirm");
		
		newPassword.add(newPasswordLabel);
		newPassword.add(newPasswordBox);
		newPassword.add(newPasswordButton);
		
		alterPassword.add(oldPassword, BorderLayout.NORTH);
		alterPassword.add(newPassword, BorderLayout.SOUTH);
		
		JPanel loginPassword = new JPanel();
		
		JLabel loginPasswordLabel = new JLabel("Enter Password");
		JTextField loginPasswordBox = new JTextField();
		loginPasswordBox.setColumns(16);
		JButton loginPasswordButton = new JButton("Confirm");
		
		loginPassword.add(loginPasswordLabel);
		loginPassword.add(loginPasswordBox);
		
		JPanel changePassword = new JPanel();
		
		JButton changePasswordButton = new JButton ("Change Password");
		
	
	
		changePasswordButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
		
		loginPasswordButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
		
		newPasswordButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});	
	}
}
