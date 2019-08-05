
/**
 * Hamburger extends the Sandwhich class
 * 
 * @author James Caldwell 
 * @version November 23, 2014
 */
public class Hamburger extends Sandwhich
{   final String TYPE = "Hamburger";
     final double PRICE = 2.00;
    final double TPRICE = 0.50;
    private int numPatty;

    public Hamburger(int _numTopping,String _topping, String _condiments,int _numPatty)
    {
        
        super(_numTopping,_topping,_condiments);
        this.numPatty = _numPatty;
    }

    public double calculatePrice()
    {
        return (PRICE * numPatty) + (super.numTopping * TPRICE);
    }

    public String toString()
    {
        if (super.condiments == "")
        {
            return numPatty + " patty " + TYPE +"\n" + "with: " + super.topping +"\nprice: $" + this.calculatePrice();
        }

        return numPatty + " patty " + TYPE +"\n" + "with: " + super.topping + " and " + super.condiments + "\nprice: $" + this.calculatePrice();

    }
}
