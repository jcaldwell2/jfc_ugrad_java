import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * The type Gui.
 *
 * @author James Caldwell
 * @version 3 /23/2016 Gui.java -- the Gui class
 */
public class Gui extends JFrame {
    /**
     * The Is visible.
     */
    public boolean isVisible;
    /**
     * The Window state.
     */
    public int windowState = 0;
    private JPanel contentPane;
    private JButton buttonShow;
    private JButton buttonExit;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private SubWindow subWin;
    private Random random;
    private int randomNum1;
    private int randomNum2;
    private int randomNum3;
    private int randomNum4;
    private int randomDx1;
    private int randomDx2;
    private int randomDx3;
    private int randomDx4;
    private int randomDy1;
    private int randomDy2;
    private int randomDy3;
    private int randomDy4;

    /**
     * Instantiates a new Gui.
     */
    public Gui() {
        setContentPane(contentPane);
        //  setModal(false);
        getRootPane().setDefaultButton(buttonShow);
        random = new Random();


        buttonShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkSubwindow();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                checkSubwindow();


                randomNum1 = random.nextInt(350);
                randomNum2 = random.nextInt(350);
                randomNum3 = random.nextInt(350);
                randomNum4 = random.nextInt(350);

                randomDx1 = random.nextInt(3) - 1;
                randomDx2 = random.nextInt(3) - 1;
                randomDx3 = random.nextInt(3) - 1;
                randomDx4 = random.nextInt(3) - 1;

                randomDy1 = random.nextInt(3) - 1;
                randomDy2 = random.nextInt(3) - 1;
                randomDy3 = random.nextInt(3) - 1;
                randomDy4 = random.nextInt(3) - 1;


                if (checkBox1.isSelected()) {
                    subWin.icon.addShape(new CarShape(randomNum1, randomNum4, 100, randomDx1, randomDy1));
                }
                if (checkBox2.isSelected()) {
                    subWin.icon.addShape(new BoatShape(randomNum2, randomNum3, 100, randomDx2, randomDy2));
                }

                if (checkBox3.isSelected()) {
                    subWin.icon.addShape(new ClockShape(randomNum3, randomNum2, 100, randomDx3, randomDy3));
                }

                if (checkBox4.isSelected()) {
                    subWin.icon.addShape(new AirplaneShape(randomNum4, randomNum1, 100, randomDx4, randomDy4));
                }
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (windowState != 2)
                    subWin.icon.removeLast();
            }
        });
    }

    private void checkSubwindow() {


        if (windowState == 0) {
            subWin = new SubWindow(this);
            subWin.setModalityType(Dialog.ModalityType.MODELESS);
            subWin.pack();
            subWin.setVisible(true);
            //   subWin.setModal(true);
            subWin.setLocationRelativeTo(this);
            subWin.setResizable(false);
            isVisible = subWin.isVisible();

            windowState = 1;
        }

        if (windowState == 2) {
            subWin.setVisible(true);
            windowState = 1;
            subWin.checkVisible();
        }


    }

    /**
     * Set window state.
     *
     * @param num the num
     */
    public void setWindowState(int num) {

        this.windowState = num;
    }

    private void onExit() {

        System.exit(0);
    }


}
