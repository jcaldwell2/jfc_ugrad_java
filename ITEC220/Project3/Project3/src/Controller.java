import java.io.*;
import java.util.Scanner;

/**
 * Controller accesses the Program of Study model and starts the program .
 * @author James Caldwell
 * @version April 6th
 */
public class Controller {


    protected ProgramOfStudy POS = new ProgramOfStudy();
    protected  String result;

    /**
     * Instantiates a new Controller.
     */
    public Controller() {

        result = POS.toString();

    }


    /**
     * Start instantiates the View
     */
    public void start(){

        View gui = new View();

    }


    /**
     * Read courses from a file.
     *
     * @param filename the filename
     */
    public  void readCourse(String filename){

        int semest,courseNo,cHours;
        String depart,title;
        File file = new File(filename);


        try {

            Scanner scan = new Scanner(file);


            while (scan.hasNext()) {

                semest = scan.nextInt(10);
                depart = scan.next();
                courseNo = scan.nextInt(10);
                cHours = scan.nextInt(10);
                title = scan.nextLine();


                POS.addCourse(new Course(semest, depart, courseNo, cHours, title));


            }


        }catch(IOException e){
            System.out.println("File doesn't exist !");
        }

        POS.createSemesters();
        POS.sortClasses();

    }

    /**
     * Load main window.
     */
    public void loadMainWindow(){

        View.getMainDialog(POS);
    }



}
