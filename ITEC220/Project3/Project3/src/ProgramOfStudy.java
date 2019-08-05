/**
 * A Program of Study for a student
 * Program of Study is the model of the POS
 *
 *
 * @author James Caldwell
 * @version April 6th
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProgramOfStudy implements Iterable<Course>, Serializable
{
    private List<Course> cList;
    protected List<Semester> sList;
    private final int MAXSEM = 10;


    
    /**
     * Constructs an initially empty Program of Study.
     */
    public ProgramOfStudy()
    {

        cList = new LinkedList<Course>();
        sList = new LinkedList<Semester>();
    }

    
    /**
     * Adds the specified course to the end of the course cList.
     * 
     * @param course the course to add
     */
    public void addCourse(Course course)
    {
        if (course != null)
            cList.add(course);
    }

    public void addSemester(Semester semester){

        if (semester != null)
            sList.add(semester);
    }

    public void createSemesters(){

      int num = 0;
        while(num <= MAXSEM) {

            addSemester((new Semester(num)));
            num++;
        }


    }

    public void sortClasses(){

        int num = 0;
        while(num <= MAXSEM) {
            for (Course course : cList) {
                if (course.getSemNo() == num)
                    semFind(num).addCourse(course);
            }
            num += 1;

        }
    }
    /**
     * Finds and returns the course matching the specified prefix and number.
     * 
     * @param _courseNo the course number of the target course
     * @param _title the title of the target course
     * @return the course, or null if not found
     */



    public Course find(int _courseNo, String _title)    {


           for(Semester semester: sList) {
               Course course = null;

               course = semester.find(_courseNo, _title);
               if(course != null)
               return course;
           }



        return null;

    }

    /**
     * Sem find.
     *
     * @param _semester the _ semester
     * @return the semester
     */
    public Semester semFind(int _semester){

        for (Semester semester : sList){
            if(semester.getSemNo() == _semester)
                return semester;
        }

        return null;


    }
    
    /**
     * Adds the specified course after the target course. Does nothing if
     * either course is null or if the target is not found.
     * 
     * @param target the course after which the new course will be added
     * @param newCourse the course to add
     */
    public void addCourseAfter(Course target, Course newCourse)
    {
        if (target == null || newCourse == null)
            return;
        
        int targetIndex = cList.indexOf(target);
        if (targetIndex != -1)
            cList.add(targetIndex + 1, newCourse);
    }

    /**
     * Replaces the specified target course with the new course. Does nothing if
     * either course is null or if the target is not found.
     * 
     * @param target the course to be replaced
     * @param newCourse the new course to add
     */
    public void replace(Course target, Course newCourse)
    {
        if (target == null || newCourse == null)
            return;
        
        int targetIndex = cList.indexOf(target);
        if (targetIndex != -1)
            cList.set(targetIndex, newCourse);
    }

    /**
     * Creates and returns a string representation of this Program of Study.
     * 
     * @return a string representation of the Program of Study
     */
    public String toString()
    {
        String result = "";
        for (Semester semester : sList)
            result += semester + "\n";
        return result;
    }
    
    /**
     * Returns an iterator for this Program of Study.
     * 
     * @return an iterator for the Program of Study
     */
    public Iterator<Course> iterator()
    {
        return cList.iterator();
    }
    
    /**
     * Saves a serialized version of this Program of Study to the specified
     * file name.
     * 
     * @param fileName the file name under which the POS will be stored
     * @throws IOException
     */
    public void save(String fileName) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(fileName); 
        ObjectOutputStream oos = new ObjectOutputStream(fos); 
        oos.writeObject(this); 
        oos.flush(); 
        oos.close(); 
    }

    /**
     * Loads a serialized Program of Study from the specified file.
     * 
     * @param fileName the file from which the POS is read
     * @return the loaded Program of Study
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ProgramOfStudy load(String fileName) throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
        ois.close();
        
        return pos;
    }
}
