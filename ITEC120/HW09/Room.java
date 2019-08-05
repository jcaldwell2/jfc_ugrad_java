
/**
 * Room Class
 * 
 * @author James Caldwell 
 * @version November 09, 2014
 */
public class Room
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private Treasure treasure;
    /**
     * Constructor for objects of class Room
     */
    public Room(String _name, String _description, Treasure _treasure)
    {
        // initialise instance variables
        this.name = _name;
        this.description = _description;
        this.treasure = _treasure;
    }

}
