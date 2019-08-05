
/**
 * BigBeef extends the ItalianBeef class
 * 
 * @author James Caldwell 
 * @version November 23, 2014
 */
public class BigBeef extends ItalianBeef
{
    final String TYPE = "Italian Beef";
    final String SIZE = "big"; 
    final double PRICE = 5.50;
    
    
   
    public BigBeef(int _numTopping,String _topping, String _condiments,String _wetOrDry)
    {
        super(_numTopping,_topping,_condiments,_wetOrDry);
       
       
     
    }

    public double calculatePrice()
    {
        return PRICE + (super.numTopping * super.TPRICE);
    }

    public String toString()
    {
        if (super.condiments == "")
        {
            return SIZE + " " + super.wetOrDry + " " + TYPE +"\n" + "with: " + super.topping +"\nprice: $" + this.calculatePrice();
        }

        return SIZE + " " + super.wetOrDry + " " + TYPE +"\n" + "with: " + super.topping + " and " + super.condiments + "\nprice: $" + this.calculatePrice();

    }
}
