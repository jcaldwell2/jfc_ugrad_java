
/**
 * Abstract class Sandwhich to model child objects
 * 
 * @author James Caldwell 
 * @version November 23, 2014
 */
public abstract class Sandwhich
{

    protected String topping;
    protected int numTopping;
    protected String condiments = "";

    public Sandwhich( int _numTopping,String _topping, String _condiments)
    {

        this.numTopping = _numTopping;
        this.topping = _topping ;
        this.condiments = _condiments;
    }

    abstract double calculatePrice();

    public String toString()
    {
        return "Joe's Sandwhich Shop \n";

    }
}
