
/**
 * Abstract class Producer - write a description of the class here
 * 
 * @author James Caldwell 
 * @version November 19,2014
 */
public abstract class Producer extends Animal
{
    protected String gives;
    
    public Producer(String _name, String _eats, String _sounds,String _gives)
    {
        super(_name,_eats,_sounds);
        this.gives = _gives;
        
        
        
    }
    
    public String toString()
    {
        return super.toString() + " gives " + this.gives;
        
        
    }
    
    
    
}
