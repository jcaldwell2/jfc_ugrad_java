/**
 * RandomTest - creating and printing out random numbers HW02
 *
 * @author  James Caldwell
 * @version September 07/2014
 * 
 */


import java.util.Random;

public class RandomTest
{

   public static void main(String[] args)
   {
   
      
      final int MAX = 3;

      Random random = new Random(System.in);

       output = random.nextInt(MAX);
    
       
       System.out.println("The random number is" + output);


      

     
   }
}
