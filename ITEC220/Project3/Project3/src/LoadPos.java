/**
 * LoadPos creates a windows and loads a specified file by name
 * @author James Caldwell
 * @version April 6th
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadPos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField loadField;
    private JButton buttonBack;

    public LoadPos() {
        setContentPane(contentPane);
        setModal(true);
        this.setTitle("Load File");
        getRootPane().setDefaultButton(buttonOK);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBack();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });


        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {

        try{
            View.getMainDialog(ProgramOfStudy.load(loadField.getText()));
        }catch(FileNotFoundException e)    {
            loadField.setText("File not found");
        }catch (IOException e){
            loadField.setText("IO Error");

        }catch (ClassNotFoundException e){

            loadField.setText("Class not found error");
        }

        dispose();
    }

    private void onCancel() {

        dispose();
    }
    public void onBack(){

        this.setVisible(false);
        View.getYesNoDialog();
        dispose();

    }


}
