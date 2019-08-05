import javax.swing.*;
import java.awt.*;



/**
 * CharArtEditor Class - Driver class to setup up frame and start the editor
 *
 * @author James Caldwell
 * @version 02/13/2015
 */
public class CharArtEditor {


    public static void main (String[] args)
    {
        inputJDialog userInput  = new inputJDialog();
        userInput.dialogRowInput();
        userInput.dialogColumnInput();

        JFrame frame = new JFrame ("Character Art Editor");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        Gui panel = new Gui(userInput.rows,userInput.cols);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(800, 650));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
