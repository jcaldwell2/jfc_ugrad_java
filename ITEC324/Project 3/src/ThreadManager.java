
import java.io.File;
import java.util.ArrayList;

/**
 * The type Thread manager.
 *
 * @author James Caldwell
 * @version 4/6/2016
 */
public class ThreadManager {


    private ArrayList<Thread> threadList;

    private Controller control;

    private int threadNo = 0;




    /**
     * Instantiates a new Thread manager.
     *
     * @param controller the controller
     */
    public ThreadManager(Controller controller) {

        this.control = controller;
        threadList = new ArrayList<>();



    }


    /**
     * Add thread.
     *
     * @param fileName the file name
     */
    public void addThread(File fileName) {

        threadList.add(new Thread(new CountThread(this.threadNo, fileName)));
        threadNo++;
    }

    /**
     * Remove thread.
     */
    public void removeThread() {

        if (!threadList.isEmpty()) {
            threadList.remove(threadList.size() - 1);
        }
    }

    /**
     * Start count.
     */
    public void startCount() {

        if (threadList.size() > 0) {
            for (Thread t : threadList) {

                try{
                    t.start();


                }catch (IllegalThreadStateException te){
                   System.out.println("Thread already started!!! Stop trying to do this!");


               }
            }
        }
    }


}



