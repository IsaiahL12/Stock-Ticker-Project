package Project;
import java.util.*;
import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class LandingPage extends JPanel {
	
	private JLabel pageName = new JLabel("Landing Page");
	public PasswordBank password = new PasswordBank();
	
	public LandingPage(){
		
		JPanel firstlayer = new JPanel();
		firstlayer.setLayout(new GridLayout (5,1,0, 30));
		firstlayer.add(pageName);
		//Note alterPassword is the JPanel where the new and old passwords are typed in.
		// changePassword is the JPanel with the button to trigger the panel swap.
		//Do not confuse the two.
		
		final JPanel alterPassword = new JPanel();
		alterPassword.setLayout(new BorderLayout(10,10));
		
		JPanel oldPassword = new JPanel();
		
		final JPasswordField oldPasswordField = new JPasswordField();
		oldPasswordField.setColumns(16);
		JLabel oldPasswordLabel = new JLabel("Enter Old Password");
		
		oldPassword.add(oldPasswordLabel);
		oldPassword.add(oldPasswordField);
		
		JPanel newPassword = new JPanel();
		
		final JPasswordField newPasswordField = new JPasswordField();
		newPasswordField.setColumns(16);
		JLabel newPasswordLabel = new JLabel("Enter New Password");
		JButton newPasswordButton = new JButton("Confirm");
		
		newPassword.add(newPasswordLabel);
		newPassword.add(newPasswordField);
		newPassword.add(newPasswordButton);
		
		alterPassword.add(oldPassword, BorderLayout.NORTH);
		alterPassword.add(newPassword, BorderLayout.SOUTH);
		
		final JPanel loginPassword = new JPanel();
		
		JLabel loginPasswordLabel = new JLabel("Enter Password");
		final JPasswordField loginPasswordField = new JPasswordField();
		loginPasswordField.setColumns(16);
		JButton loginPasswordButton = new JButton("Confirm");
		
		loginPassword.add(loginPasswordLabel);
		loginPassword.add(loginPasswordField);
		loginPassword.add(loginPasswordButton);
		
		final JPanel changePassword = new JPanel();
		
		JButton changePasswordButton = new JButton ("Change Password");
		changePassword.add(changePasswordButton);

		final JPanel cancelchangePassword = new JPanel();

		JButton cancelchangePasswordButton = new JButton ("Cancel");
		cancelchangePassword.add(cancelchangePasswordButton);

		
		firstlayer.add(loginPassword);
		firstlayer.add(alterPassword);
		firstlayer.add(changePassword);
		firstlayer.add(cancelchangePassword);

		alterPassword.setVisible(false);
		cancelchangePassword.setVisible(false);
		this.add(firstlayer);

		
		changePasswordButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				alterPassword.setVisible(true);
				loginPassword.setVisible(false);
				changePassword.setVisible(false);
				cancelchangePassword.setVisible(true);
				
			}
		});	
		
		cancelchangePasswordButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				alterPassword.setVisible(false);
				loginPassword.setVisible(true);	
				changePassword.setVisible(true);
				cancelchangePassword.setVisible(false);
			}
		});	
		
		loginPasswordButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				String convert = new String(loginPasswordField.getPassword());
				if(convert == PasswordBank.checkPassword())
				{
				// Insert chnage to next page
					alterPassword.setVisible(true);
					loginPassword.setVisible(false);
					changePassword.setVisible(false);
					cancelchangePassword.setVisible(true);
				}
			}
		});	
		
		newPasswordButton.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				String changepasswordto = new String(newPasswordField.getPassword());
				String confirmpassword = new String(oldPasswordField.getPassword());
				if(confirmpassword == PasswordBank.checkPassword()){
					PasswordBank.changePassword(changepasswordto);
				}
			}
		});	
	}
}
