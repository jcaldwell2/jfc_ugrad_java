/**
*	PasswordTest.java
*	
*	@author James Caldwell	
*	@version September 21,2014
*
*
*/ 


public class PasswordTest
{
	
	public static void main(String [] args)
	
	{
		
		Password pass = new Password();
		System.out.println("Let's test our password generator with 0,1,2.\n");
		System.out.println(pass.generatePassword(0));
		System.out.println(pass.generatePassword(1));
		System.out.println(pass.generatePassword(2));
		System.out.println("\nNow let's use some passwords and test their strengths.\n");
		
		System.out.println(pass.passwordStrength("strength"));
		System.out.println(pass.passwordStrength("1234"));
		System.out.println(pass.passwordStrength("aBdBk123983"));
		System.out.println(pass.passwordStrength("ZERO"));
		System.out.println(pass.passwordStrength("132435Ac$"));
	
	
	}
	
	
	
	
	
}