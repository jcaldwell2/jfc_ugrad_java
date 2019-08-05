
/**
 * Write a description of class Horse here.
 * 
 * @author James Caldwell
 * @version November 19,2014
 */
public class Horse extends Animal
{
    protected String type;

    
    public Horse(String _name, String _type)
    {
        super(_name, "hay", "nay");
        this.type = _type;
        
    }

   
}
