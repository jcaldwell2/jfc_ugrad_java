
/**
 * Write a description of class Farm here.
 * 
 * @author James Caldwell 
 * @version November 19,2014
 */
public class Farm
{
    public static void main(String[] args)
    {

        Animal pig = new Pig("Wilbur");

        System.out.println(pig);

        Animal[] pen = new Animal[6];
        pen[0] = pig;

        Animal horse1 = new Horse("Mr. Ed", "riding horse");
        pen[1] = horse1;

        Animal horse2 = new Horse("Secretariat", "racing horse");
        pen[2] = horse2;

        Animal cow = new Cow("Bessie");
        pen[3] = cow;

        Animal sheep = new Sheep("Dolly");
        pen[4] = sheep;

        Animal goat = new Goat("Billy");
        pen[5] = goat;
        System.out.println("Welcome to the Pittges Farm.");
        System.out.println("Let me introduce you to the animals:");
        for(Animal animal:pen)
        {
            System.out.println(animal);
        }
    }
}
