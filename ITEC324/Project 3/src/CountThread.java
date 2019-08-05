import java.awt.*;
import java.io.*;
import java.util.Scanner;

/**
 * The type Count thread.
 *
 * @author James Caldwell
 * @version 4 /6/2016
 */
public class CountThread implements Runnable {


    private File fileName;
    private int wordCount;
    private int threadNo;



    /**
     * The File name string.
     */
    public String fileNameString;

    /**
     * Instantiates a new Count thread.
     *
     * @param _fileName the file name
     */
    public CountThread(int _threadNo, File _fileName){

         threadNo = _threadNo;
        fileName = _fileName;
    }


    /**
     * Run.
     */
    @Override
    public void run() {


        try {

            FileReader fileReader =
                    new FileReader(fileName);


            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            Scanner scan = new Scanner(bufferedReader);

            while(scan.hasNext()) {
                scan.next();
                wordCount++;
            }


            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "File not found '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

        }

         fileNameString = "" + fileName;
        ShowCount dialog = new ShowCount(fileNameString.substring(4,fileNameString.length()),wordCount);
        dialog.pack();
        dialog.setVisible(true);

        Controller.writeFile(fileNameString.substring(4,fileNameString.length()),wordCount,threadNo);


    }


}
