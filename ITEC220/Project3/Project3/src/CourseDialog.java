/**
 * CourseDialog handles adding,removing, and adding a grade for a course
 * @author James Caldwell
 * @version April 6th
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;


public class CourseDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonAdd;
    private JButton buttonBack;
    private JTextField crsNameField;
    private JTextField creditHrsField;
    private JTextField courseNumField;
    private JTextField departField;
    private JTextField semField;
    private JButton removeButton;
    private JLabel statusLabel;
    private JButton addGradeButton;
    private JTextField gradeField;
    private ProgramOfStudy POS;

    /**
     * Instantiates a new Course dialog.
     *
     * @param programOfStudy the program of study
     */
    public CourseDialog(ProgramOfStudy programOfStudy) {

       POS = programOfStudy;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonAdd);

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRemove();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        addGradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGrade();

            }
        });
    }




    private void onRemove() {

        Course course = getCourse();


        if(course == null){
            statusLabel.setText("Course status: Course not found");
        }else{
            statusLabel.setText("Course status: Course has been found and removed");
            POS.semFind(course.getSemNo()).removeCourse(course);

        }

    }

    private void onGrade() {

        Course course = getCourse();
        Scanner scan = new Scanner(gradeField.getText());
        char grade = scan.next().charAt(0);

        if (course == null) {
            statusLabel.setText("Course status: Course not found");
        } else {
            statusLabel.setText("Course status: Course has been found and grade added");
            POS.find(course.getCourseNo(),course.getTitle()).setGrade(grade);

        }
    }

    private void onAdd() {



        addCourse();
        statusLabel.setText("Course status: Course has been added");


    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }



    private void addCourse() {

            String string = semField.getText()+ " " + departField.getText() + " " + courseNumField.getText()
                + " " +  creditHrsField.getText() + " " + crsNameField.getText();
            Scanner scan = new Scanner(string);

                int semest = scan.nextInt(10);
                String depart = scan.next();
                int courseNo = scan.nextInt(10);
                int cHours = scan.nextInt(10);
                String title = scan.nextLine();


             (POS.semFind(semest)).addCourse(new Course(semest, depart, courseNo, cHours, title));


        }




    private Course getCourse(){

        Course course ;
        String string = semField.getText()+ " " + departField.getText() + " " + courseNumField.getText()
                + " " +  creditHrsField.getText() + " " + crsNameField.getText();

        Scanner scan = new Scanner(string);


        int semest = scan.nextInt(10);
        String depart = scan.next();
        int courseNo = scan.nextInt(10);
        int cHours = scan.nextInt(10);
        String title = scan.nextLine();

        course = POS.find(courseNo,title);



        return course;
    }



}


