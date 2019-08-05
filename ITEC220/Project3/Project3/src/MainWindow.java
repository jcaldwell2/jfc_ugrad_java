/**
 * MainWindow creates the Main interface to the program
 * @author James Caldwell
 * @version April 6th
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JDialog {
    private JPanel contentPane;
    private JButton findACourseButton;
    private JButton addACourseButton;
    private JButton viewProgramOfStudyButton;
    private JButton saveProgramOfStudyButton;
    private JTextArea mainDisplay;
    private JButton exitButton;
    private ProgramOfStudy POS;
    private JPopupMenu findMenu = new JPopupMenu();

    /**
     * Instantiates a new Main window.
     *
     * @param programOfStudy the program of study
     */
    public MainWindow(ProgramOfStudy programOfStudy) {

        POS = programOfStudy;
        findACourseButton.setComponentPopupMenu(findMenu);
        setContentPane(contentPane);
        setModal(true);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        viewProgramOfStudyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainDisplay.setText(POS.toString());

            }
        });
        saveProgramOfStudyButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                View.getSaveDialog(POS);

            }
        });

        addACourseButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                View.getCourseDialog(POS);

            }
        });
        findACourseButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                findMenu.removeAll();

                int xPos = (MouseInfo.getPointerInfo().getLocation().x)+ 50;
                int yPos = (MouseInfo.getPointerInfo().getLocation().y)- 50;

                addPopUpItems();
                findMenu.setLocation(xPos,yPos);
                findMenu.setVisible(true);
            }
        });

    }

    private JMenuItem makeMenuItem(Course course) {
        JMenuItem item = new JMenuItem(course.toString());
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainDisplay.setText(course.toString());
            }
        });
        return item;
    }




    private void addPopUpItems(){

        for(Semester semester: POS.sList)
            for(Course course: semester.classList)
                 findMenu.add(makeMenuItem(course));



    }


}
