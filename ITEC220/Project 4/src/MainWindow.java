
/**
 * MainWindow is the view part of the MVC and contain the GUI elements
 *
 * @author James Calwell
 * @version 4/13/2015
 */

import main.java.riotapi.RiotApiException;
import org.json.JSONException;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * The type Main window.
 */
public class MainWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel avatarField;
    private JTextField playerNameField;
    private JLabel playerNameLabel;
    private JLabel playerIdLabel;
    private JTextArea matchHistoryField;
    private JTextArea winLossField;
    private JLabel playerLevelField;
    private Controller controller;

    /**
     * Instantiates a new Main window.
     *
     * @throws IOException the iO exception
     * @throws JSONException the jSON exception
     */
    public MainWindow()throws IOException, JSONException {



        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (JSONException e1) {
                    e1.printStackTrace();
                } catch (RiotApiException e1){
                    e1.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK()throws IOException, JSONException, RiotApiException {

        try {
            String temp = playerNameField.getText().toLowerCase().replaceAll("\\s", "");
            controller = new Controller(temp);
            avatarField.setText("");
            avatarField.setIcon(new ImageIcon(controller.getIcon()));
            playerNameLabel.setText(controller.getPlayerName());
            playerIdLabel.setText("player ID: " + controller.getPlayerId());
            matchHistoryField.setText(controller.getMatchHistory());
            winLossField.setText(controller.getPlayerStats());
            playerLevelField.setText("Player level: " + setPlayerLevel());
        } catch (NullPointerException e) {
            playerNameField.setText("Try a different name");
        }
    }
    private void onCancel() {

        dispose();
    }

    /**
     * Set player label.
     *
     * @param name the name
     */
    public  void setPlayerLabel(String name){

       playerNameLabel.setText(name);

    }

    public long setPlayerLevel(){

        return controller.getPlayerLevel();
    }


}
