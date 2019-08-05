import java.io.Serializable;

/**
 * The type Course creates course objects
 */
public class Course implements Serializable
{
	private int semester;
	private int courseNo;
    private int creditHrs;
	private String title;
    private String department;
	private char grade;

    /**
     * Constructs the course with the specified information.
     *
     * @param _semester the semester of the course
     * @param _department the department of the course
     * @param _courseNo the course no
     * @param _creditHrs credit hours of the course
     * @param _title the course title
     */
	public Course(int _semester, String _department, int _courseNo, int _creditHrs, String _title)
	{
		this.semester = _semester;
		this.department = _department;
		this.courseNo = _courseNo;
        this.creditHrs = _creditHrs;
        this.title = _title;
        this.grade = ' ';
	}


    /**
     * Returns the course number of the course
     *
     * @return the courseNo
     */
	public int getCrsNo()
	{

        return courseNo;
	}


    /**
     * Gets department.
     *
     * @return the string
     */
    public String getDepart(){

        return department;

    }

    /**
     * Gets title.
     *
     * @return  string
     */
    public String getTitle(){

        return title;
	}

    /**
     * Gets course number
     *
     * @return  int
     */
    public int getCourseNo(){

        return courseNo;
    }

    /**
     * Gets semester number
     *
     * @return  int
     */
    public int getSemNo(){
        return semester;
    }

    /**
     * Returns the grade for this course.
     *
     * @return the grade for this course
     */
	public char getGrade()
	{
		return grade;
	}

    /**
     * Sets the grade for this course to the one specified.
     *
     * @param grade the new grade for the course
     */
	public void setGrade(char grade)
	{
		this.grade = grade;
	}
	
	/**
	 * Returns true if this course has been taken (if a grade has been received).
	 * 
	 * @return true if this course has been taken and false otherwise
	 */

	public boolean equals(Object other)
	{
		boolean result = false;
		if (other instanceof Course)
		{
			Course otherCourse = (Course) other;
			if (courseNo == (otherCourse.getCrsNo()) &&
					title == otherCourse.getTitle())
				result = true;
		}
		return result;
	}
	
	/**
	 * Creates and returns a string representation of this course.
	 * 
	 * @return a string representation of the course
	 */
	public String toString()
	{
		String result = semester + " " + department + " " + courseNo + " " + creditHrs +  " " + title  +
                " grade: " + grade   ;

		return result;
	}
}
