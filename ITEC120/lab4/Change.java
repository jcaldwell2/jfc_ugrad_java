/**
 * Change.java Break a an amount of money down into change
 *
 * @author  James Caldwell
 * @version September 05/2014
 * Got help looking at http://www.javaprogrammingforums.com/whats-wrong-my-code/14648-help-my-java-program-making-change-entered-double.html
 */


import java.util.Scanner;

public class Change
{

   public static void main(String[] args)
   {
   
      
      int quarters, nickels, dimes, ones, fives, tens, pennies, totalAmount ;
      double amount ;

      Scanner scan = new Scanner(System.in);

      System.out.println("Enter an amount of money");
      amount = scan.nextDouble();
      
      totalAmount = (int)amount; // cast the amount to an int so theres no decimals
      totalAmount = (int)(amount * 100); // change the total input to cents and to int

      
      // get the total amount and break it down with each divisible amount and subtract it from the previous amount
    // couldn't determine proper equations and use the link referenced above as a guide
      tens = (totalAmount / 1000); 
      fives = (int) ((amount-(tens*10))/5);
      ones = (int) ((amount-(tens*10)-(fives*5))/1);
      quarters = (int) ((amount-(tens*10)-(fives*5)-(ones*1))/.25);
      dimes = (int) ((amount-(tens*10)-(fives*5)-(ones*1)-(quarters*.25))/.10);
      nickels =  (int) ((amount-(tens*10)-(fives*5)-(ones*1)-(quarters*.25)-(dimes*.10))/.05);
      pennies =  (int) ((amount-(tens*10)-(fives*5)-(ones*1)-(quarters*.25)-(dimes*.10)-(nickels*.05))/.01);
      // Pennies come out off and can't determine why even though the equations are sound
      
       
      
System.out.println("Ten dollar bills: " + tens);
System.out.println("Five dollar bills: " + fives);
System.out.println("One dollar bills: " + ones);
System.out.println("Quarters: " + quarters);
System.out.println("Dimes: " + dimes);
System.out.println("Nickels: " + nickels);
System.out.println("Pennies: " + pennies);
    

      

     
   }
}
