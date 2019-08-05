/**
 * L09B.java -- methods that operate on strings using For loops. 
 * 
 * @author  James Caldwell
 * @version 24-Sept-2014
 */
import java.util.Random;

public class L09B
{
    /**
     * min() - returns the minimum character in the given string.
     *
     * @param str the string to be processed 
     * @return the minimum character in the given string
     */
    public char min(String str)
    {
        char low = '!';
        char result = '!';
        char testCase = 'Z';
        for(int count = 0;count<str.length(); ++count){
            
            

            if (count > 0){
                 result = str.charAt(count);
                 if (result < testCase)
                  testCase = result;
                 low = result;

            }
        }
        
        return low; 
    }

    /**
     * max() - returns the maximum character in the given string.
     *
     * @param str the string to be processed 
     * @return the maximum character in the given string
     */
    public char max(String str)
    {
        char high = '!';
         char result = '!';
        char testCase = 'a';
        for(int count = 0;count<str.length(); ++count){
            
            

            if (count > 0){
                 result = str.charAt(count);
                 if (result > testCase)
                 high = result;
                 testCase = result;
            }
        }

        return high; 
    }

    /**
     * isFound() - answers if the given character is found in the given string
     * 
     * @param str the string to processed
     * @param ch  the character to be found
     * @return true if the character is found, false if not found.
     */
    public boolean isFound(String str, char ch)
    {
        boolean found = false;
         for(int count = 0;count<str.length(); ++count){
            
            

       
              char  result = str.charAt(count);
                 if (result == ch){
                 found = true;
            }
        

       
    
}
 return found; 
}


    /**
     * timesFound() - returns the number of times the given character 
     *                appears in the given string.
     * 
     * @param str the string to be processed
     * @param ch  the character to be found
     * @return the number of times the given character is found 
     *         in the given string. 
     */
    public int timesFound(String str, char ch)
    {
        int total = 0;
        for(int count = 0;count<str.length(); ++count){
            
            

       
              int  result = str.charAt(count);
                 if (result == ch){
                ++total;
            }

        
    }
return total; 
}
    /**
     * isVowel() - answers if the given character is a vowel.
     *
     * @param ch the character to be processed
     * @return answers if the given character is a vowel.
     */
    public boolean isVowel(char ch){
        if(ch == 'a'|| ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' ||ch == 'u' || ch == 'U')
            return true;
        
        return false;
    }

    /**
     * numVowels() - returns the number of vowels in the given string.
     *
     * @param str the string to be processed
     * @return the number of vowels in the given string. 
     */
    public int numVowels(String str)
    {
        int total = 0; 
          for(int count = 0;count<str.length(); ++count){
                 
                 if ((str.charAt(count) == 'a'|| str.charAt(count) == 'A' || str.charAt(count) == 'e' || str.charAt(count) == 'E' || str.charAt(count) == 'i' || str.charAt(count) == 'I' || str.charAt(count) == 'o' || str.charAt(count) == 'O' ||str.charAt(count) == 'u' || str.charAt(count) == 'U'))
                 
                 ++total;
            
 
                }     
   return total; 
                }

             

}