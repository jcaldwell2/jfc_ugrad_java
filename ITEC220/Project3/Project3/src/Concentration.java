/**
 * Concentration asks the user which concentration they are
 * and loads a recommended program of study
 * @author James Caldwell
 * @version April 6th
 */

import javax.swing.*;
import java.awt.event.*;


public class Concentration extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox concenBox;
    private JButton buttonBack;
    private Controller control = new Controller();


    /**
     * Instantiates a new Concentration.
     */
    public Concentration() {
        setContentPane(contentPane);
        setModal(true);
        this.setTitle("Pick a concentration");
        getRootPane().setDefaultButton(buttonOK);



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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


        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBack();

                dispose();
            }
        });
    }


    private void onOK() {



        if(concenBox.getSelectedItem()== "Information Technology (IS)")
            control.readCourse("InformationSystems.dat");

        if(concenBox.getSelectedItem()== "Web Development (WD)")
            control.readCourse("WebDevelopment.dat");

        if(concenBox.getSelectedItem()== "Computer Science (CS)")
            control.readCourse("ComputerScience.dat");

        if(concenBox.getSelectedItem()== "Database (DB)")
            control.readCourse("Database.dat");

        if(concenBox.getSelectedItem()== "Networks (NW)")
            control.readCourse("Networks.dat");

        if(concenBox.getSelectedItem()== "Software Engineering (SE)")
            control.readCourse("SoftwareEngineering.dat");


        this.setVisible(false);
        control.loadMainWindow();
        dispose();



    }

    private void onCancel() {

        dispose();
    }

    /**
     * On back goes back to the previous window.
     */
    public void onBack(){

        this.setVisible(false);
        View.getYesNoDialog();
        dispose();

    }


}
