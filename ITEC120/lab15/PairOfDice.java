
/**
 * PairOfDice - Create pair of 6 sided dice objects
 * 
 * @author James Caldwell and Lance Price
 * @version October 17, 2014
 */
public class PairOfDice
{

    private Die die1;
    private Die die2;

    public PairOfDice()
    {
        die1 = new Die();
        die2 = new Die();

    }

    public void roll()
    {
        die1.roll();
        die2.roll();

        
    }

    public int getDie1FaceValue()
    {

        return die1.getFaceValue();
    }

    public int getDie2FaceValue()
    {

        return die2.getFaceValue();
    }

    public int getTotalFaceValue()
    {
        int totalFaceValue = 0;

        totalFaceValue = die1.getFaceValue() + die2.getFaceValue();
        return totalFaceValue;
    }

    public String toString()
    {
        String result = (Integer.toString(die1.getFaceValue()) + Integer.toString(die2.getFaceValue()));

      return result;
    }
    
}
