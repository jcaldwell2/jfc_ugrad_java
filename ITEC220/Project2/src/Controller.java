import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author James Caldwell
 * @version 3/5/2015
 *
 * Controller - Creates buttons with actions interacting with
 * the stack from the Model class and handles input
 */
public class Controller {

    private char[] chars = {'-','+','*','/','0','1','2','3','4','5','6','7','8','9'};

    private JTextField userInput = new JTextField();
    private JTextField output = new JTextField();

    private JButton clear = new JButton("Clear");
    private JButton solve = new JButton("Solve");

    private Model model = new Model();

    /**
     *  Create the textfields and jbuttons
     *  and add action listeners to the JButtons
     */
    public Controller(){

        this.userInput.setPreferredSize(new Dimension(100,25));
        this.userInput.addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {



               if(Character.isLetter(e.getKeyChar()) ){
                   output.setText("Characters are not allowed");
                   clearInput();
               }else{
                   clearOutput();
               }

           }

           @Override
           public void keyPressed(KeyEvent e) {


           }

           @Override
           public void keyReleased(KeyEvent e) {

           }
        });

        this.output.setPreferredSize(new Dimension(100, 25));


      solve.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String input = userInput.getText();

             if(model.isValid(input).equals("Valid")) {
                  model.evaluate(input);
                  output.setText("" + model.getPeek());
              }else{
                  output.setText(model.isValid(input));
              }
          }
      });



        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clearAll();

            }
        });

    }



    public void clearAll(){

        userInput.setText("");
        output.setText("");

    }

    public void clearOutput(){

        output.setText("");
    }

    public void clearInput(){

        userInput.setText("");
    }



    public JTextField getTextField(){

        return userInput;
    }

    public JTextField getOutField(){

        return output;
    }

    public JButton getClearButn(){

        return clear;
    }

    public JButton getSolveButn(){

        return solve;
    }


}
