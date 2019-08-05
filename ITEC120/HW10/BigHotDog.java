
/**
 * Extends the HotDog class
 * 
 * @author James Caldwell 
 * @version November 23, 2014
 */
public class BigHotDog extends HotDog
{
    
    final String SIZE = "foot long"; 
    final double PRICE = 2.50;
   


    public BigHotDog(int _numTopping,String _topping, String _condiments)
    {
       super(_numTopping,_topping,_condiments);
    }

    public double calculatePrice()
    {
        return PRICE + (super.numTopping * super.TPRICE);
    }
     public String toString()
    {
        if (super.condiments == "")
        {
            return SIZE + " " + super.TYPE +"\n" + "with: " + super.topping +"\nprice: $" + this.calculatePrice();
        }

        return SIZE + " " + super.TYPE +"\n" + "with: " + super.topping + " and " + super.condiments + "\nprice: $" + this.calculatePrice();

    }
}
