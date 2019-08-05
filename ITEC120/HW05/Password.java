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
     
    public char randomChar(int stringLength)
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


	public String generatePassword(int passString)
	
	{   
		
		
		
		int count = 0;
		String output = "";
		while (count < passString){
			output +=  randomChar(passString);
			++count;
			
		
		
		}
		
		return output;
	}	
	public int passwordStrength(String randPassword)
	{
		
		int passStrength = 0;
		String num = "[0-9]+";
		String lower = "[abcdefghijklmnopqrstuvwxyz]+";
		String upper = "[ABCDEFGHIJKLMNOPQRSTUVWXYZ]+";
		
					
//		if (randPassword.length() < 8)
//			passStrength = 0;
//		if(randPassword.length() >= 8)
//		 	 passStrength = 1;
//		if (randPassword.matches(num))
		if (randPassword.matches(lower))
			passStrength = 1;
		if (randPassword.matches(upper))
			passStrength = 1;
		if ((randPassword.matches(lower))&&((randPassword.matches(upper))))
			passStrength += 2;
		
		if ((randPassword.matches(num))&&((randPassword.matches(upper))))
			passStrength += 2;		
		if ((randPassword.matches(lower))&&((randPassword.matches(num))))
			passStrength += 3;
		if ((randPassword.matches(lower))&&((randPassword.matches(upper))&&(randPassword.matches(num))))
			passStrength += 4;
		
		
		
		
		
		
		return passStrength;
		
}

	
}	
