package UserInterface.SwingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailForm extends JFrame{

    public EmailForm()  {
        setSize(500,250);
        add(emailform);
        setTitle("Register Your Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JPanel emailform;
    private JButton btn_email_onay;
    private JLabel txt_email_message;





}
