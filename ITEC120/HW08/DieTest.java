
/**
 * Die Driver to test the player class methods
 * 
 * @author James Caldwell 
 * @version October 22, 2014
 */
public class DieTest
{

    public static void main (String[] args)
    {
        int testNum = 1;
        Die die1 = new Die();

        System.out.println(testNum + ": " );

        if(die1.getValue() == 1)
            System.out.println("Pass");
        else 
            System.out.println("Fail");

        int minVal = 6;
        int maxVal = 1;
        testNum = 2;
        for(int i = 0; i<100;i++)
        { die1.roll();
            if (die1.getValue() > maxVal)
                maxVal = die1.getValue();
            if (die1.getValue() < minVal)
                minVal = die1.getValue();
        }

        System.out.println(testNum + ": ");
        if (minVal == 1 && maxVal == 6)
            System.out.println("Pass");
        else 
            System.out.println("Fail");

        testNum = 3;
        die1.setValue(6);

        System.out.println(testNum + ": " +
            (die1.toString().equals("Die: " + die1.getValue())
                ? "Pass" : "Fail"));

        Die die2 = new Die();

        testNum = 4;
        die1.setValue(6);
        die2.setValue(6);
        System.out.println(testNum + ": ");

        if(die1.compareTo(die2) == 0)
            System.out.println("Pass");
        else 
            System.out.println("Fail");

        testNum = 5;
        die1.setValue(1);
        die2.setValue(6);
        System.out.println(testNum + ": ");

        if(die1.compareTo(die2) == -1)
            System.out.println("Pass");
        else 
            System.out.println("Fail");

        testNum = 6;
        die1.setValue(5);
        die2.setValue(1);
        System.out.println(testNum + ": ");

        if(die1.compareTo(die2) == 1)
            System.out.println("Pass");
        else 
            System.out.println("Fail");
          
            testNum = 7;
        die1.setValue(5);
        die2.setValue(5);
        System.out.println(testNum + ": ");

        if(die1.equalsTo(die2) )
            System.out.println("Pass");
        else 
            System.out.println("Fail");

    }
}
