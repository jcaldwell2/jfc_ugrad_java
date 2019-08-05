import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type List gui.
 *
 * @author James Caldwell
 * @version 4 /26/2016
 */
public class ListGui extends JFrame {
    private JPanel mainPanel;
    private JButton addAddressToFrontButton;
    private JButton printReverseAddressListButton;
    private JButton createReverseAddressListButton;
    private JButton printAddressListButton;
    private JTextField textFieldDOB;
    private JTextField textFieldAddress;
    private JTextField textFieldEmail;
    private JTextField textFieldTel;
    private JTextField textFieldName;
    private JTextArea textAreaOutput;
    private JButton lookupPhoneNumberByButton;
    private JButton lookupEmailByNameButton;
    private JButton lookupNameByPhoneButton;
    private JButton lookupDOBByNameButton;
    private JButton printAddressListSizeButton;
    private JButton addAddressToTheButton;
    private JButton clearAllButton;

    private AddressList AL;



    /**
     * Instantiates a new List gui.
     */
    public ListGui() {

        this.add(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();

        AL = new AddressList();


        addAddressToFrontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkFieldsEmpty() == false) {
                    AL.addToFront(textFieldName.getText(), textFieldTel.getText(), textFieldEmail.getText(),
                            textFieldAddress.getText(), textFieldDOB.getText());
                    textAreaOutput.setText("Address Added!");

                } else {
                    textAreaOutput.setText("You are missing information");
                }
            }
        });
        printAddressListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaOutput.setText(AL.toString());
            }
        });
        addAddressToTheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkFieldsEmpty() == false) {
                    AL.addToBack(textFieldName.getText(), textFieldTel.getText(), textFieldEmail.getText(),
                            textFieldAddress.getText(), textFieldDOB.getText());
                    textAreaOutput.setText("Address Added!");

                } else {
                    textAreaOutput.setText("You are missing information");
                }
            }
        });
        printAddressListSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AL.sizeOf() == 1) {
                    textAreaOutput.setText("There is currently " + AL.sizeOf() + " entry in the Address List");
                } else {
                    textAreaOutput.setText("There are currently " + AL.sizeOf() + " entries in the Address List");
                }
            }
        });
        lookupPhoneNumberByButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaOutput.setText(AL.phoneNumberByName(textFieldName.getText()));
            }
        });
        lookupEmailByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaOutput.setText(AL.emailByName(textFieldName.getText()));
            }
        });
        lookupNameByPhoneButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaOutput.setText(AL.nameByPhoneNumber(textFieldTel.getText()));
            }
        });
        lookupDOBByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaOutput.setText(AL.dobByName(textFieldName.getText()));
            }
        });
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        createReverseAddressListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AL = AL.reverse();
                textAreaOutput.setText("The Address List has been reversed!");
            }
        });
        printReverseAddressListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaOutput.setText(AL.reverseToString());
            }
        });
    }

    private boolean checkFieldsEmpty() {

        if (textFieldName.getText().equals("") || textFieldAddress.getText().equals("") ||
                textFieldDOB.getText().equals("") || textFieldEmail.getText().equals("") ||
                textFieldTel.getText().equals("")) {
            return true;
        }
        return false;
    }

    private void clearFields() {

        textFieldName.setText("");
        textFieldAddress.setText("");
        textFieldDOB.setText("");
        textFieldEmail.setText("");
        textFieldTel.setText("");

        textAreaOutput.setText("");
    }
}

