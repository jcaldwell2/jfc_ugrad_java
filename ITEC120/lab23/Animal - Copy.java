
/**
 * Abstract class Animal - write a description of the class here
 * 
 * @author James Caldwell
 * @version November 19,2014
 */
public abstract class Animal
{

    protected String name;
    protected String food;
    protected String sound;

    public Animal(String _name, String _food, String _sound)
    {
        this.name = _name;
        this.food = _food;
        this.sound = _sound;

    }

    public String speak()
    {
        return this.sound;

    }

    public void eat(String[] string)
    {
        

    }

    public String toString()
    {
        return this.name + " eats " + this.food + " says " + this.sound;
    }
}
