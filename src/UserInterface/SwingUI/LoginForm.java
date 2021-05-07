package UserInterface.SwingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JPanel loginform;
    private JTextField edtxt_login_email;
    private JPasswordField edtxt_login_password;
    private JCheckBox showPasswordCheckBox;
    private JButton loginButton;

    public LoginForm() throws HeadlessException {



        add(loginform);
        setTitle("Login to E-Trade");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Deneme amaçlı bir bilgi mesajı bu");
            }
        });
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showPasswordCheckBox.isSelected())
                {
                    showPasswordCheckBox.setText("hide password");
                    edtxt_login_password.setEchoChar((char).0);
                }
                else
                {
                    showPasswordCheckBox.setText("show password");
                    edtxt_login_password.setEchoChar('*');
                }
            }
        });
    }
}
