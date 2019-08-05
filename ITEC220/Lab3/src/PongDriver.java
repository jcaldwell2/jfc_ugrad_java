/**
 * @author James Caldwell
 */
import javax.swing.*;
import java.awt.*;
public class PongDriver {





        public static void main(String[] args) {

            JFrame frame = new JFrame("Pong");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setSize(500, 500);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);


            View pongPanel = new View();
            frame.add(pongPanel, BorderLayout.CENTER);



        }

}
