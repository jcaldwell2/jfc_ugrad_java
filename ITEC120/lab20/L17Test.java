import java.io.*;

import java.util.Scanner;

public class L17Test
{
    public static void main(String[] args) throws IOException 
    {
        FileReader fr2 = new FileReader("treasures.csv");
        while (fr2.hasNext())
        {
            String input = fr2.getRecord();

            Scanner parse = new Scanner(input);
            parse.useDelimiter(",");
            int sum = 0;
            int count = 0;
            while (parse.hasNext())
            {
                String token = parse.next();
                System.out.print(token + " ");

                count++;
            }

            System.out.println();
        }
    }
}
