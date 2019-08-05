/**
*	Password.java
*	
*	@author James Caldwell	
*	@version September 21,2014
*
*
*/ 



import java.util.Random;


public class Password

{
    /**
     * randomChar - returns a random character as a char.
     * Taken from D2L
     * return random character as a char.
     */
     
    public char randomChar()
    {
        final int NUM_CHARS = 62; 

        Random rand = new Random();
        int num = rand.nextInt(NUM_CHARS);

        if (num <= 9)
           num += 48;
        else if (num <= 35)
           num += 55;
        else
           num += 61;

        return (char) num;
    }


	public String generatePassword(String passString)
	
	{   
		
		String stringLength = passString.length;
		password = new char(passString);
		return password;
		
		
	}




}