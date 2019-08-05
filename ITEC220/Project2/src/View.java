import javax.swing.*;
import java.awt.*;

/**
 * @author James Caldwell
 * @version 3/5/2015
 *
 * View - creates the gui elements of the program
 */

public class View extends JFrame{


    private JPanel mainPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel midPanel = new JPanel();
    private JPanel botPanel = new JPanel();
    private JLabel title = new JLabel("Type in Post Fix Expression",JLabel.CENTER);
    private JLabel result = new JLabel("Result",JLabel.CENTER);
    private Controller controller = new Controller();

    public View(){

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(375, 300));
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Post Fix Evaluator");
        this.setLocationRelativeTo(null);


        topPanel.setLayout(new BorderLayout(60,20));
        topPanel.setPreferredSize(new Dimension(325,75));


        midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.X_AXIS));


        botPanel.setLayout(new BorderLayout(60,20));
        botPanel.setPreferredSize(new Dimension(325,75));

        addComponents();

    }

    /**
     * Add the JComponents and organize them
     */
    public void addComponents(){

        this.add(mainPanel);
        mainPanel.add(topPanel);
        mainPanel.add(midPanel);
        mainPanel.add(botPanel);

        topPanel.add(title,BorderLayout.NORTH);
        topPanel.add(controller.getTextField(),BorderLayout.SOUTH);

        midPanel.add(controller.getClearButn());
        midPanel.add(controller.getSolveButn());



        botPanel.add(result,BorderLayout.CENTER);
        botPanel.add(controller.getOutField(),BorderLayout.SOUTH);


    }


}
