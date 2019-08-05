import javax.swing.*;
import java.awt.event.*;

/**
 * @author James Caldwell
 * @version 3/23/2016
 */

public class SubWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonHide;
    private JButton buttonExit;
    private JLabel drawField;
    private final int DELAY = 10;
    private Gui gui;
    protected ShapeIcon icon;
    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private Timer timer;


    /**
     * Instantiates a new Sub window.
     */
    public SubWindow(Gui _gui) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonHide);

        this.gui = _gui;


        buttonHide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onHide();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
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

        icon = new ShapeIcon(ICON_WIDTH, ICON_HEIGHT);
        drawField.setIcon(icon);
        // Milliseconds between timer ticks
        timer = new Timer(DELAY, new
                ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        icon.translate();
                        drawField.repaint();

                        checkVisible();
                    }
                });
        timer.start();


    }

    private void onHide() {
// add your code here
        SubWindow.this.setVisible(false);
        this.gui.setWindowState(2);

    }

    private void onCancel() {
// add your code here if necessary
        this.gui.setWindowState(0);
        this.dispose();
    }

    public void checkVisible() {

        if (this.gui.windowState == 2)
            timer.stop();

        if (this.gui.windowState == 1)
            timer.start();
    }


}
