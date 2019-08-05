
/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure
{

    private double value;
    private String name;

    public Treasure(double _value, String _name)
    {
        this.name = _name;
        this.value = _value;
    }

    public double getVal()
    {
        return this.value;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean equals(Treasure treasure)
    {
        return (this.value == treasure.value && this.name == treasure.name);
    }

    public double compareTo(Treasure treasure)
    {

        return this.value - treasure.value;
    }
}
