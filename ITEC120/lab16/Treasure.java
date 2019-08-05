
/**
 * Write a description of class Treasure here.
 * 
 * @author James Caldwell 
 * @version October 22, 2014
 */
public class Treasure
{
    // instance variables 
    private String name;
    private String description;
    private double weight;
    private int value;

    /**
     * Constructor for objects of class Treasure
     */
    public Treasure(String _name, String _description, double _weight, int _value)
    {
        this.name = _name;
        this.description = _description;
        this.weight = _weight;
        this.value = _value;

    }

    public String toString()
    {
        return this.name + "" + this.description + "" + this.value + "" +this.weight + "";

    }

    public boolean equals(Treasure tObject)

    {
      
    // Could not figure out how to compare the tObject with a String or the instance variables 
    // and commented this out 
    //    if(tObject ==)
    //        return true;

        return false;
    }
 public double compareTo(Treasure _treasure)
    {
        return this.value - _treasure.value;   
    }
}