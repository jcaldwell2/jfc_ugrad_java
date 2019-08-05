/**
 * @author James Caldwell
 * @version April 6th
 */

import javax.swing.*;
import java.awt.event.*;


public class YesNoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonYes;
    private JButton buttonCancel;
    private JButton buttonNo;

    /**
     * Instantiates a new Yes no dialog.
     */
    public YesNoDialog() {
        setContentPane(contentPane);
        setModal(true);
        this.setTitle("Program Start");
        getRootPane().setDefaultButton(buttonCancel);

        buttonYes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onYes();
            }
        });

        buttonNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNo();
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
    }

    private void onYes() {
// add your code here
        this.setVisible(false);
        View.getLoadPoS();
        dispose();
    }

    private void onNo() {
// add your code here if necessary
        this.setVisible(false);
        View.getConcenDialog();
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    /**   public static void main(String[] args) {
     YesNoDialog dialog = new YesNoDialog();
     dialog.pack();
     dialog.setLocationRelativeTo(null);
     dialog.setVisible(true);
     System.exit(0);
     }


     */

}