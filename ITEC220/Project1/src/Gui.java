import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Gui Class - Create and setup the GUI elements
 *
 * @author James Caldwell
 * @version 02/13/2015
 */
public class Gui extends JPanel  {

    private JButton tiles[][];
    private JButton usrButns[] = new JButton[7];
    private JButton curSelect = new JButton("-");
    private JButton changeTo = new JButton("-");
    private JButton changeAll = new JButton("Change All");
    private JButton reset = new JButton("Reset Tiles");

    private JPanel grid = new JPanel();
    private JPanel gridHolder = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel userSelect = new JPanel();
    private JPanel curntSelection = new JPanel();
    private JPanel changePanel = new JPanel();


    private JLabel menuLabel = new JLabel();
    private JLabel selectLabel = new JLabel();
    private JLabel changeLabel = new JLabel();

    private JTextArea charCount = new JTextArea();

    private String chars[] = {"-","+","V","^","/","\\","|"};
    private String selection = "-";
    private String changeSelect = "-";



    private int row;
    private int col;
    private int index;
    private int dash;
    private int plus;
    private int vee;
    private int caret;
    private int fSlash;
    private int bSlash;
    private int vBar;


    /**
     * Gui Constructor
     *
     * @param _row get user input for how many rows
     * @param _col get user input for how many cols
     */

    public Gui(int _row, int _col){
        this.row = _row;
        this.col = _col;

        this.setPreferredSize(new Dimension(500, 500));
        this.setLayout(new BorderLayout());

        this.add(gridHolder, BorderLayout.CENTER);
        this.add(leftPanel, BorderLayout.WEST);

        this.curSelect.setPreferredSize(new Dimension(40, 40));
        this.curSelect.setBorder(null);

        this.menuLabel.setText("Select a character");
        this.selectLabel.setText(" Current Selection");
        this.changeLabel.setText("<html>Change all the  <br> characters below to the  selection character");


        setupPanels();
        buildTiles();
        buildUsrButns();
        //initial character count of the tiles
        getCharCount();
    }

    // create all the panels
    private void setupPanels(){

        curntSelection.add(curSelect);

        leftPanel.add(menuLabel);
        leftPanel.add(userSelect);
        leftPanel.setBackground(Color.BLACK);
        leftPanel.add(selectLabel);
        leftPanel.add(curntSelection);
        leftPanel.add(changeLabel);
        leftPanel.add(changePanel);
        leftPanel.add(reset);
        leftPanel.add(charCount);
        leftPanel.setPreferredSize(new Dimension(150, 200));

        menuLabel.setBackground(Color.WHITE);
        menuLabel.setOpaque(true);
        menuLabel.setPreferredSize(new Dimension(110, 20));

        selectLabel.setBackground(Color.WHITE);
        selectLabel.setOpaque(true);
        selectLabel.setPreferredSize(new Dimension(110, 20));

        changeLabel.setBackground(Color.WHITE);
        changeLabel.setOpaque(true);
        changeLabel.setPreferredSize(new Dimension(140,80));

        charCount.setPreferredSize(new Dimension(140,80));
        charCount.setText("The current char \n count of all chars" +
                "- :" + dash);


        userSelect.setLayout(new GridLayout(4, 2, 4, 4));
        userSelect.setPreferredSize(new Dimension(100, 150));
        userSelect.setBackground(Color.BLACK);

        changePanel.add(changeTo);
        changePanel.add(changeAll);

        gridHolder.add(grid);
        grid.setLayout(new GridLayout(this.row, this.col));

        tiles = new JButton[this.row][this.col];




    }

    /**
     * buildTiles - Create the tiles for the art editor
     * based upon user input
     */
    private void buildTiles(){



        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                tiles[i][j] = new JButton("-");
                tiles[i][j].setBorder(null);
                tiles[i][j].setPreferredSize(new Dimension(20, 20));
                tiles[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(int i=0;i<Gui.this.row;i++) {
                            for (int j = 0; j < Gui.this.col; j++) {
                                if (e.getSource() == tiles[i][j])
                                    Gui.this.changeTile(i, j);
                                    Gui.this.getCharCount();
                            }

                        }
                    }
                });

                grid.add(tiles[i][j]);



            }



        }




    }

    /**
     * create the user buttons
     * add action listeners
     */
    private void buildUsrButns() {

        for (int i = 0; i < usrButns.length; i++) {
            usrButns[i] = new JButton(chars[i]);
            usrButns[i].addActionListener(new ActionListener() {
               //change the tiles to the selection
                @Override
                public void actionPerformed(ActionEvent e) {
                     Gui.this.index = Arrays.asList(usrButns).indexOf(e.getSource());
                     Gui.this.curSelect.setText(chars[index]);
                     Gui.this.selection = (chars[index]);
                }
            });
            {

                userSelect.add(usrButns[i]);


            }

            changeTo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changeSelect = selection;
                    changeTo.setText(changeSelect);

                }
            });

            changeAll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0;i<Gui.this.row;i++) {
                        for (int j = 0; j < Gui.this.col; j++) {
                            if (tiles[i][j].getText().equals(changeSelect))
                                Gui.this.changeTile(i, j);

                        }
                    }
                }
            });

            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui.this.resetTiles();
                }
            });
        }
    }

    // change the tiles to the current character selection
    private void changeTile(int i, int j){

        tiles[i][j].setText(selection);
        getCharCount();
    }

    // get the current count of characters in use
    private void getCharCount(){
         dash = 0;
         plus = 0;
         vee = 0;
         caret = 0;
         fSlash = 0;
         bSlash = 0;
         vBar = 0;

        for(int i=0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {

                if (tiles[i][j].getText().equals(chars[0]))
                    dash++;
                if (tiles[i][j].getText().equals(chars[1]))
                    plus++;
                if (tiles[i][j].getText().equals(chars[2]))
                    vee++;
                if (tiles[i][j].getText().equals(chars[3]))
                    caret++;
                if (tiles[i][j].getText().equals(chars[4]))
                    fSlash++;
                if (tiles[i][j].getText().equals(chars[5]))
                    bSlash++;
                if (tiles[i][j].getText().equals(chars[6]))
                    vBar++;

            }


        }

        //update the character count
        charCount.setText("The current character \n count of all characters \n" +
                " - : " + dash + " + : " + plus + " V : " + vee +
                " ^ : " + caret + "\n / : " + fSlash + " \\ : " + bSlash +
                " | : " + vBar);

    }

    //reset the tiles
    private void resetTiles(){

        for(int i=0;i<this.row;i++) {
            for (int j = 0; j < this.col; j++) {
                tiles[i][j].setText("-");
                getCharCount();
            }
        }
    }
    



}

