
/**
 * HotDog extends the Sandwhich class
 * 
 * @author James Caldwell 
 * @version November 23, 2014
 */
public class HotDog extends Sandwhich
{
    final String TYPE = "Hot Dog";
    final String SIZE = "regular"; 
    final double PRICE = 1.50;
    final double TPRICE = 0.30;

    public HotDog(int _numTopping,String _topping, String _condiments)
    {
        super(_numTopping,_topping,_condiments);
    }

    public double calculatePrice()
    {
        return PRICE + (super.numTopping * TPRICE);
    }

    public String toString()
    {
        if (super.condiments == "")
        {
            return SIZE + " " + TYPE +"\n" + "with: " + super.topping +"\nprice: $" + this.calculatePrice();
        }

        return SIZE + " " + TYPE +"\n" + "with: " + super.topping + " and " + super.condiments + "\nprice: $" + this.calculatePrice();

    }
}