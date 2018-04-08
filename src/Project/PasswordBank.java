package Project;


public class PasswordBank {

	public String password = "Default";
	public int hash = 34;

	PasswordBank()
	{
		
	}
	
	String checkPassword()
	{
		return password;
	}
	
	void changePassword(String change)
	{
		password = change;
	}
	
	
}
