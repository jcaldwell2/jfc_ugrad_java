
/**
 * Class BoxTest - Driver class used to test Box objects and setter/getter methods
 * 
 * @author James Caldwell   
 * @version October 19, 2014
 */
public class BoxTest
{

    public static void main (String[]args)
    {

        int testNum = 1;
        Box box1 = new Box(2, 3, 4);
        System.out.println(testNum + ": " +
            (box1.toString().equals("2x3x4") ? "Pass" : "Fail"));

        testNum = 2;
        box1.setHeight(8);
        box1.setWidth(12);
        box1.setDepth(20);
        System.out.println(testNum + ": " +
            (box1.toString().equals("8x12x20") ? "Pass" : "Fail"));

        testNum =3; 
        Box box2 = new Box(10, 5, 22);
        System.out.println(testNum + ": " +
            (box2.toString().equals("10x5x22") ? "Pass" : "Fail"));

        testNum = 4;
        box2.setHeight(12);
        box2.setWidth(15);
        box2.setDepth(30);
        System.out.println(testNum + ": " +
            (box2.toString().equals("12x15x30") ? "Pass" : "Fail"));

        testNum = 5;
        box2.setFull(true);
        box1.setFull(false);
        if (box2.getFull()== true && box1.getFull() == false)
            System.out.println(testNum + ": Pass");
        else
            System.out.println(testNum + ": False");

        testNum = 6;
        if( box1.getHeight() == 8 && box1.getWidth() == 12 && box1.getDepth() ==20)
            System.out.println(testNum + ": Pass");
        else
            System.out.println(testNum + ": False");

            testNum = 7;
        if( box2.getHeight() == 12 && box2.getWidth() == 15 && box2.getDepth() ==30)
            System.out.println(testNum + ": Pass");
        else
            System.out.println(testNum + ": False");
    }

}