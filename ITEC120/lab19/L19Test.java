
/**
 * L19 Test - Test various methods of L19 using the tests similar to lab12
 * 
 * @author James Caldwell 
 * @version November 5th, 2014
 */
public class L19Test
{
    public static void main(String[] args)
    {
        Treasure t1 = new Treasure(500.50,"Gold");
        Treasure t2 = new Treasure(325.75,"Sword");
        Treasure t3 = new Treasure(50.55,"Silver Ingot");
        Treasure t4 = new Treasure(1000.75,"Xcalibur");
        Treasure t5 = new Treasure(777.77,"Arcane Staff");
        Treasure t6 = new Treasure(.01,"Penny");
        Treasure t7 = new Treasure(123.45,"Magic Scroll");
        Treasure t8 = new Treasure(433.29,"Jade Dagger");
        Treasure t9 = new Treasure(264.23,"Amethyst");
        Treasure t10 = new Treasure(1500.00,"Ancient Spell Book");

        Treasure[] tArray1 = new Treasure[10];
        Treasure[] tArray2 = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10};
        Treasure[] tArray3 = {};
        Treasure[] tArray4 = {t5};
        Treasure[] tArray5 = {t6,t8};
        L19 l19Obj = new L19();

        int test = 1;
        //isFound Tests
        System.out.println("Test " + test);
        if(l19Obj.isFound(tArray2, t6) == true)
            System.out.println("Pass");
        if(l19Obj.isFound(tArray2, t6) == false)
            System.out.println("Fail");
        test++;
    }	
}