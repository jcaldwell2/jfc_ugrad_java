/**
 * Created by James on 2/7/2015.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameGui {

    private JButton squares[][];
    JPanel grid = new JPanel();
    JPanel bg = new JPanel();
    JLabel status = new JLabel();
    private Grid mineGrid = new Grid(20,20);



    public GameGui(){

        squares = new JButton[20][20];

        grid.setPreferredSize(new Dimension(350, 350));
        grid.setLayout(new GridLayout(20, 20));
        grid.setVisible(true);

        status.setSize(100, 100);
        status.setText("Game Started!");


        bg.setPreferredSize(new Dimension(300, 300));
       // bg.setLayout(new BorderLayout());
        bg.setVisible(true);
        bg.add(grid,BorderLayout.CENTER );
        bg.add(status, BorderLayout.SOUTH);
       // bg.setBackground(Color.black);





    }

    private void buildButtons(){
        for( int i=0;i<20;i++){
            for( int j=0;j<20;j++){
                final JButton tile = new JButton();
                squares[i][j] = tile;
                squares[i][j].setPreferredSize(new Dimension(300, 300));
                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < 20; i++) {
                            for (int j = 0; j < 20; j++) {

                                if (e.getSource() == squares[i][j])
                                    if (mineGrid.checkMine(i, j))
                                        endGame(i,j);


                                        else {
                                        squares[i][j].setBackground(Color.GREEN);
                                        checkArea(i,j);
                                        if(mineGrid.checkWin()==true)
                                            gameWon();
                                    }


                            }
                            }
                    }
                });
                grid.add(squares[i][j]);
            }
        }
    }


    public void createGui(){

        buildButtons();
        JFrame frame = new JFrame("My Minesweeper");
        frame.add(bg);
        frame.setSize(375, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);





    }



    public void endGame(int i ,int j){

        squares[i][j].setBackground(Color.RED);

        status.setText("You lost!");
    }
    public void gameWon(){

        status.setText("You win!");
    }


    public void checkArea(int i, int j) {

        int row = 0;
        int col = 1;
        int count = 6;

        while (count != 0) {

            if ((mineGrid.checkMine(i + row, j + col))) {
                squares[i + row][j + col].setBackground(Color.YELLOW);



            } else {
                squares[i + row][j + col].setBackground(Color.GREEN);


            }

            row = 1;
            col = 0;

            if ((mineGrid.checkMine(i + row, j + col))) {
                squares[i + row][j + col].setBackground(Color.YELLOW);



            } else {
                squares[i + row][j + col].setBackground(Color.GREEN);


            }

            row = 0;
            col = -1;

            if ((mineGrid.checkMine(i + row, j + col))) {
                squares[i + row][j + col].setBackground(Color.YELLOW);



            } else {
                squares[i + row][j + col].setBackground(Color.GREEN);


            }

            row = -1;
            col = 0;
            if ((mineGrid.checkMine(i + row, j + col))) {
                squares[i + row][j + col].setBackground(Color.YELLOW);



            } else {
                squares[i + row][j + col].setBackground(Color.GREEN);


            }

            count--;
        }
    }

}
