
/**
 * Die class to create a six sided die object
 * 
 * @author James Caldwell 
 * @version October 22, 2014
 */
import java.util.Random;
public class Die
{
    // instance variables - replace the example below with your own
    final int MIN_VALUE = 1;
    final int MAX_VALUE = 6;
    private Random die;
    private int value;

    /**
     * Constructor for objects of class Die
     */
    public Die()
    {
       
        die = new Random();
        value = MIN_VALUE;
    }

    public void setValue(int _value)
    {
        this.value = _value;
    }

    public int getValue()
    {
        return this.value;
    }
    
    public int roll()
    {
       value = die.nextInt(MAX_VALUE) + MIN_VALUE;
       return value;
        
    }
    public String toString()
    {
        return "Die: "+value;
    }
    
    
    public boolean equalsTo(Die die)
    {
        return (this.value == die.value);
    
    }
    
    public int compareTo(Die die)
    {
        if(this.value > die.value)
        return 1;
            else if(this.value < die.value)
            return -1;
            
            return 0;
            
        }
    
    
}
