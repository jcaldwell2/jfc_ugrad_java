/**
 * FileReader -- reads records (rows) from a file. 
 *
 * @author  Jeff Pittges
 * @version 15-Mar-2012
 */
import java.io.*; 
import java.util.Scanner;

public class FileReader  
{
    private int lineCount;			// number of lines processed thus far 
    private Scanner fileScan;		// scans the given file 

    public FileReader(String filename) throws IOException 
    {
		this.lineCount = 0;
		this.fileScan = new Scanner(new File(filename));
    }

	public boolean hasNext()
	{
		return fileScan.hasNext();
	}

    public String getRecord() throws IOException
    {
		String line = ""; 

		if (fileScan.hasNext())
		{
		   line = fileScan.nextLine();
	   	   ++lineCount;
		}
		else
		   line = "DONE"; 

		return line; 
    }
}

