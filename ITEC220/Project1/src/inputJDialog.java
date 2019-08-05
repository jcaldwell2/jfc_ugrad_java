import javax.swing.*;

/**
 * inputJDialog class - create JDialogs to ask user for input for Rows and Columns
 *
 * @author James Caldwell
 * @version 02/13/2015
 */
public class inputJDialog extends JDialog {
    public int rows;
    public int cols;

    public void dialogRowInput() {


            boolean inputAccepted = false;
            while (!inputAccepted) {
                try {

                    //Get user input for number of rows
                    String stringInputRow = JOptionPane.showInputDialog("Enter number of rows" +
                            " between 5 and 30");
                    int number = Integer.parseInt(stringInputRow);

                    //Show a message if the number is out of range and ask again
                    if (number > 30 || number < 5) {
                        JOptionPane.showMessageDialog(null, "That number is not between 5 \n" + "and 30!\n");

                    } else {

                        //Input was accepted
                        inputAccepted = true;
                        this.rows = number;
                    }

                  //If the input is other than a number catch it and show a message
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "That is not an acceptable input!");
                }


            }

    }

    public void dialogColumnInput()



        {
            boolean inputAccepted2 = false;
            while (!inputAccepted2) {
                try {

                    //Get user input for number of columns
                    String stringInputCol = JOptionPane.showInputDialog("Enter number of columns" +
                            " between 5 and 30");
                    int number = Integer.parseInt(stringInputCol);

                    //If user input is outside of range display a message and ask again
                    if (number > 30 || number < 5) {
                        JOptionPane.showMessageDialog(null, "That number is not between 5 \n" + "and 30!\n");

                    } else {

                        //input is accepted
                        inputAccepted2 = true;
                        this.cols = number;
                    }
                  //Catch input if it is not a number and display a message
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "That is not an acceptable input!");
                }
            }
        }

}

