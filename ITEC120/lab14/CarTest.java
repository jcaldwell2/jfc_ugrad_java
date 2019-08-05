
/**
 * Write a description of class CarTest here.
 * 
 * @author James caldwell 
 * @version October 15, 2014
 */
public class CarTest
{
    public static void main (String[] args)
    {
        int testNum = 1;
        Car car1 = new Car("Toyota", "Prius", 2004);
        System.out.println(testNum + ": " +
            (car1.toString().equals("Toyota-Prius (2004)")
                ? "Pass" : "Fail"));
        testNum = 2;
        Car car2 = new Car("Honda", "Civic", 2008);
        System.out.println(testNum + ": " +
            (car2.toString().equals("Honda-Civic (2008)")
                ? "Pass" : "Fail"));
        testNum = 3;        
        System.out.println(testNum + ": " + (car1.getMake().equals("Toyota")
                ? "Pass" : "Fail"));

        testNum = 4;        
        System.out.println(testNum + ": " + (car2.getModel().equals("Civic")
                ? "Pass" : "Fail"));
        testNum = 5;        
        System.out.println(testNum + ": " + (car1.getYear() == 2004
                ? "Pass" : "Fail"));
                testNum = 6;        
        System.out.println(testNum + ": " + (car2.setYear(1996) == 1996
                ? "Pass" : "Fail"));
                testNum = 7;        
        System.out.println(testNum + ": " + (car1.setMake("Jaguar").equals("Jaguar")
                ? "Pass" : "Fail"));
                testNum = 8;        
        System.out.println(testNum + ": " + (car2.setModel("Supra").equals("Supra")
                ? "Pass" : "Fail"));

    }

}