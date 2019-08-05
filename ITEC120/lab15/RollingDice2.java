
/**
 * RollingDice2 - use the methods and objects create from the PairOfDice class
 * 
 * @author James Caldwell and Lance Price 
 * @version October 17, 2014
 */
public class RollingDice2
{
    
    public static void main (String []args)
    {
        PairOfDice pairOfDice = new PairOfDice();
        
        pairOfDice.roll();
       
        System.out.println("Die One: " + pairOfDice.getDie1FaceValue() + ", Die Two: " + pairOfDice.getDie2FaceValue());
        System.out.println("Total face value is:"+pairOfDice.getTotalFaceValue());
        System.out.println("The pair of dice as a String " + pairOfDice.toString());
        
    }
}
