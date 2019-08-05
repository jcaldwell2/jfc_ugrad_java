
/**
 *  TreasureAndRoomsDriver driver class for reading data and creating objects
 *
 * @author James Caldwell 
 * @version November 9th, 2014
 */

import java.io.*;
import java.util.Scanner;

public class TreasureAndRoomsDriver
{
    public static void main(String[] args) throws IOException 
    {
        FileReader reader1 = new FileReader("treasures.csv");
        FileReader reader2 = new FileReader("rooms.csv");
        int roomTotal = 0;
        int treasTotal = 0;

        String file1 = reader1.getRecord();
        String file2 = reader2.getRecord();
        Scanner scan1 = new Scanner(file1);
        Scanner scan2 = new Scanner(file2);

        roomTotal = scan2.nextInt();
        treasTotal = scan1.nextInt();
        Room[] rooms = new Room[roomTotal];

        scan1.useDelimiter(",");
        scan2.useDelimiter(",");
        System.out.println(roomTotal);
        System.out.println(treasTotal);

        file1 = reader1.getRecord();
        file2 = reader2.getRecord();
        //Treasure t1 = new Treasure(scan1.next(),scan1.next(),scan1.nextInt(),scan1.nextDouble());
        System.out.println(file1);
        //System.out.println(scan1.next());

        //this is where i had problems trying to use scan to read the String file1 so that I 
        //could create a new treasure object, instead i kept getting a null exception when run

         
        //         
        //         file1 = reader1.getRecord();
        //         file2 = reader2.getRecord();

        //         
        //                 while (reader1.hasNext())
        //         {
        //             String input1 = reader1.getRecord();
        //             System.out.println(input1);
        //            // Treasure t1 = new Treasure(scan1.next(),scan1.next(),scan1.nextInt(),scan1.nextDouble());
        // 
        //         }

        //         Treasure t1 = new Treasure(scan1.next(),scan1.next(),scan1.nextInt(),scan1.nextDouble());
        //         Treasure t2 = new Treasure(scan1.nextLine(),scan1.nextLine(),scan1.nextInt(),scan1.nextDouble());
        //         Treasure t3 = new Treasure(scan1.nextLine(),scan1.nextLine(),scan1.nextInt(),scan1.nextDouble());
        //         Treasure t4 = new Treasure(scan1.nextLine(),scan1.nextLine(),scan1.nextInt(),scan1.nextDouble());
        //         Treasure t5 = new Treasure(scan1.nextLine(),scan1.nextLine(),scan1.nextInt(),scan1.nextDouble());
        //         Treasure t6 = new Treasure(scan1.nextLine(),scan1.nextLine(),scan1.nextInt(),scan1.nextDouble());
        //         Room r0 = new Room(scan2.nextLine(),scan2.nextLine(),t1); 
        //         
        //         
        //         System.out.println(t1);
        //         System.out.println(t2);

        
        
        
        // 
        //        
        //         String file1 = reader2.getRecord();
        //         String file2 = reader2.getRecord();
        //         String fileBoth = file1 +","+ file2;
        // 
        //         System.out.println(fileBoth);
        // 
        //         int total = 0;
        //         Scanner scan = new Scanner(fileBoth);
        //         scan.useDelimiter(",");
        //         for(int i=0;i<rowBoth.length();i++)
        //             total += scan.nextInt();

    }

}
