import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Semester contains a linked list of Course objects
 * @author James Caldwell
 * @version April 6th
 */
public class Semester implements Iterable<Course>, Serializable {


    protected List<Course> classList;
    private int semester;

    /**
     * Instantiates a new Semester.
     *
     * @param _semester the _ semester
     */
    public Semester(int _semester){

       this.semester = _semester;
       classList =  new LinkedList<Course>();



    }


    /**
     * Get semester number
     *
     * @return the int
     */
    public int getSemNo(){

        return semester;
    }


    /**
     * Add course.
     *
     * @param course the course
     */
    public void addCourse(Course course)
    {
        if (course != null)
            classList.add(course);
    }

    public String toString()
    {
        String result = "";
        for (Course course : classList)
            result += course + "\n";
        return result;
    }

    /**
     * Find course.
     *
     * @param _courseNo the _ course no
     * @param _title the _ title
     * @return the course
     */
    public Course find(int _courseNo, String _title)    {



        for(Course course: classList){


            if(course.getCourseNo() == _courseNo && course.getTitle().contains(_title))
                  return course;
        }


        return null;
    }

    /**
     * Remove course.
     *
     * @param _course the _ course
     */
    public void removeCourse(Course _course) {

        Iterator<Course> itr = classList.iterator() ;
        System.out.println(_course);
       if(_course != null)
        while(itr.hasNext()) {
            Course course = itr.next();
           if (course.equals(_course))
               itr.remove();

       }


    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Course> iterator() {
        return classList.iterator();
    }
}
