import javax.swing.*;
import java.awt.event.*;
import java.io.File;


public class Gui extends JFrame {

    private JPanel contentPane;
    private JButton buttonCountWords;
    private JButton buttonQuit;
    private JTextField textField1;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private JTextArea textArea;
    private JButton button1;

    private String fileName;
    private  Controller control;


    public Gui(Controller controller) {

        this.control = controller;

        setContentPane(contentPane);

        getRootPane().setDefaultButton(buttonAdd);

        buttonCountWords.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCount();
            }
        });

        buttonQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        });

// call onQuit() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onQuit();
            }
        });

// call onQuit() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onQuit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });


    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onQuit() {

        dispose();
        System.exit(0);
    }

    private void onAdd(){

        fileName = textField1.getText();


            File file = new File("src/" + fileName);
            if (file.exists()) {
                textArea.append(fileName);
                textArea.append("\n");
                control.createThread(file);
                textField1.setText("Please enter a new file name");
            }else{
                textField1.setText("Please try a different file or check file name!");
            }

    }

    private void onCount() {
        try {
            control.startThreads();

        } catch (StringIndexOutOfBoundsException e){
            System.out.println("No threads in thread manager!");
        }


    }



}
