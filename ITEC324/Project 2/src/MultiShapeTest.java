import java.awt.*;


/**
 * @author James Caldwell
 * @version 3/23/2016
 * MultiShapeTest.java  -- Driver class
 */
public class MultiShapeTest {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {

        Gui gui = new Gui();
        gui.setTitle("Main Window");
        gui.pack();
        gui.setVisible(true);
        gui.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        gui.setLocationRelativeTo(null);


    }
}

