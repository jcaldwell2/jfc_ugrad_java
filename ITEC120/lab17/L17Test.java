import java.io.*;
import java.util.Scanner;

public class L17Test
{
    public static void main(String[] args) throws IOException 
    {
        FileReader reader1 = new FileReader("start.txt");

        while (reader1.hasNext())
        {
            String input1 = reader1.getRecord();
            System.out.println(input1);

        }

        FileReader reader2 = new FileReader("scores.csv");
        String row1 = reader2.getRecord();
        String row2 = reader2.getRecord();
        String rowBoth = row1 +","+ row2;
        
        System.out.println(rowBoth);
       
        int total = 0;
        Scanner scan = new Scanner(rowBoth);
        scan.useDelimiter(",");
       for(int i=0;i<rowBoth.length();i++)
       total += scan.nextInt();

        
       
        
       
            

    }
}
