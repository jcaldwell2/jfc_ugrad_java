import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 * The type Controller.
 *
 * @author James Caldwell
 * @version 4 /6/2016
 */
public class Controller {

    private Gui gui;
    private ThreadManager threadManager;


    /**
     * Instantiates a new Controller.
     */
    public  Controller(){

        gui = new Gui(this);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.pack();

        threadManager = new ThreadManager(this);
    }


    /**
     * Create thread.
     *
     * @param fileName the file name
     */
    protected void createThread(File fileName){

        threadManager.addThread(fileName);
    }

    /**
     * Start threads.
     */
    protected void startThreads(){ threadManager.startCount();}


    /**
     * Write file.
     *
     * @param inputFile the input file
     * @param count     the count
     * @param _threadNo the thread no
     */
    public static synchronized void writeFile(String inputFile, int count, int _threadNo) {
      
        String fileName = "";
        
        try {

            fileName = "wordcount.txt";

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            if (file.canWrite()) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
                bufferedWriter.write("Thread " + _threadNo + ": the file “<" + inputFile + ">” has <" + count + "> words.\n");
                bufferedWriter.newLine();
                bufferedWriter.close();
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("File cannot be written: \n" + fileName);
        }
    }






}
