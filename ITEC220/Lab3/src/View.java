/**
 * @author James Caldwell
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View extends JPanel implements ActionListener, KeyListener{

    private boolean showTitleScreen = true;
    private boolean playing = false;
    private boolean gameOver = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean wPressed = false;
    private boolean sPressed = false;

    private int ballX = 250;
    private int ballY = 250;
    private int diameter = 15;
    private int ballDeltaX = 5;
    private int ballDeltaY = 3;

    private int playerOneX = 25;
    private int playerOneY = 250;
    private int playerOneWidth = 10;
    private int playerOneHeight = 50;

    private boolean playerTwo = false;
    private int playerTwoX = 465;
    private int playerTwoY = 250;
    private int playerTwoWidth = 10;
    private int playerTwoHeight = 50;

    private int paddleSpeed = 2;

    private int playerOneScore = 0;
    private int playerTwoScore = 0;



    public View(){
        setBackground(Color.BLACK);

        this.setPreferredSize(new Dimension(500,500));

        setFocusable(true);
        addKeyListener(this);


        Timer timer = new Timer(1000/60, this);
        timer.start();
    }


    public void actionPerformed(ActionEvent e){
        step();
    }

    public void step(){

        if(playing){

            if (wPressed) {
                if (playerOneY-paddleSpeed > 0) {
                    playerOneY -= paddleSpeed;
                }
            }
           if (sPressed) {
                if (playerOneY + paddleSpeed + playerOneHeight < getHeight()) {
                    playerOneY += paddleSpeed;
                }
            }

          if(playerTwo == true) {

              if (upPressed) {
                  if (playerTwoY - paddleSpeed > 0) {
                      playerTwoY -= paddleSpeed;
                  }
              }
              if (downPressed) {
                  if (playerTwoY + paddleSpeed + playerTwoHeight < getHeight()) {
                      playerTwoY += paddleSpeed;
                  }
              }
          }
            if(playerTwo!= true){
                moveAi();
            }


            int nextBallLeft = ballX + ballDeltaX;
            int nextBallRight = ballX + diameter + ballDeltaX;
            int nextBallTop = ballY + ballDeltaY;
            int nextBallBottom = ballY + diameter + ballDeltaY;

            int playerOneRight = playerOneX + playerOneWidth;
            int playerOneTop = playerOneY;
            int playerOneBottom = playerOneY + playerOneHeight;

            float playerTwoLeft = playerTwoX;
            float playerTwoTop = playerTwoY;
            float playerTwoBottom = playerTwoY + playerTwoHeight;



            if (nextBallTop < 0 || nextBallBottom > getHeight()) {
                ballDeltaY *= -1;
            }


            if (nextBallLeft < playerOneRight) {

                if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop) {

                    playerTwoScore ++;

                    if (playerTwoScore == 3) {
                        playing = false;
                        gameOver = true;
                    }

                    if(playerTwo == false){

                        playerTwoY = 250;
                    }
                    ballX = 250;
                    ballY = 250;
                }
                else {
                    ballDeltaX *= -1;
                }
            }


            if (nextBallRight > playerTwoLeft) {

                if (nextBallTop > playerTwoBottom || nextBallBottom < playerTwoTop) {

                    playerOneScore ++;

                    if (playerOneScore == 3) {
                        playing = false;
                        gameOver = true;
                    }

                    if(playerTwo == false){

                        playerTwoY = 250;
                    }

                    ballX = 250;
                    ballY = 250;
                }
                else {
                    ballDeltaX *= -1;
                }
            }


            ballX += ballDeltaX;
            ballY += ballDeltaY;
        }


        repaint();
    }

    public void moveAi () {

        int yPos = (playerTwoY / 2);

        if(playerTwoY > 425)
            playerTwoY = 420;
        if(playerTwoY < 3)
            playerTwoY = 5;

            if(ballY > yPos && playerTwoY < 427 ) {

                    playerTwoY += ballDeltaY ;

                }

        if(ballY < yPos && playerTwoY > 0 ) {

                playerTwoY -= ballDeltaY ;
            }
        }



    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setColor(Color.WHITE);

        if (showTitleScreen) {

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
            g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
            g.drawString("Java Pong", 165, 100);

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

            g.drawString("Press 1 or 2 for players", 150, 400);
        }
        else if (playing) {

            int playerOneRight = playerOneX + playerOneWidth;
            int playerTwoLeft =  playerTwoX;



          //  g.drawString("ball x:" + ballX +", player2 y:" + playerTwoY, 165, 200);

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
            g.drawString(String.valueOf(playerOneScore), 100, 100);
            g.drawString(String.valueOf(playerTwoScore), 400, 100);


            g.fillOval(ballX, ballY, diameter, diameter);


            g.fillRect(playerOneX, playerOneY, playerOneWidth, playerOneHeight);
            g.fillRect(playerTwoX, playerTwoY, playerTwoWidth, playerTwoHeight);
        }
        else if (gameOver) {

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            g.drawString(String.valueOf(playerOneScore), 100, 100);
            g.drawString(String.valueOf(playerTwoScore), 400, 100);

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
            if (playerOneScore > playerTwoScore) {
                g.drawString("Player 1 Wins!", 165, 200);
            }
            else {
                g.drawString("Player 2 Wins!", 165, 200);
            }

            g.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            g.drawString("Press space to restart.", 150, 400);
        }
    }



    public void keyTyped(KeyEvent e) {}



    public void keyPressed(KeyEvent e) {
        if (showTitleScreen) {
            if (e.getKeyCode() == KeyEvent.VK_1) {
                showTitleScreen = false;
                playing = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_2) {
                showTitleScreen = false;
                playing = true;
                playerTwo = true;
            }
        }
        else if(playing){
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = true;
            }
            else if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = true;
            }
        }
        else if (gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                gameOver = false;
                showTitleScreen = true;
                playerOneY = 250;
                playerTwoY = 250;
                ballX = 250;
                ballY = 250;
                playerOneScore = 0;
                playerTwoScore = 0;
            }
        }
    }


    public void keyReleased(KeyEvent e) {
        if (playing) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = false;
            }
            else if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = false;
            }
        }
    }

}
