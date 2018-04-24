package Project;
import  java.security.SecureRandom.*;



public class PasswordBank {

	public static String password = "Default";
	public int hash = 34;

	PasswordBank()
	{
		changePassword("Default");
	}
	
	static String checkPassword()
	{
		return password;
	}
	
	static void changePassword(String change)
	{
		password = change;
	}
	
	
}
