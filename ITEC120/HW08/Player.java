
/**
 * Player Class to setup player object
 * 
 * @author James Caldwell 
 * @version October 22, 2014
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String name;
    private int score;

    /**
     * Constructor for objects of class Player
     */
    public Player(String _name)
    {
        this.name = _name;
    }

    public void setScore(int _score)
    {
        this.score = _score;
    }

    public int getScore()
    {
        return this.score;
    }

    public String getName()
    {
        return this.name;
    }

    public int addToScore(int _score)
    {
        this.score += _score;
        return this.score;
    }

    public String toString()
    {
        return "Player: " + this.name + "Score: " + this.score;
    }

}