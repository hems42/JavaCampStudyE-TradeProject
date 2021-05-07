package UserInterface.SwingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpForm extends JFrame {

    private JPanel loginformpanel;
    private JTextField edtxt_name;
    private JTextField edtxt_surname;
    private JTextField edtxt_signup_email;
    private JPasswordField edtxt_signup_password;
    private JCheckBox showPasswordCheckBox;
    private JLabel chckbx_show_password;
    private JButton btn_signup;
    private JButton btn_already_signed_up;

    public SignUpForm(){

        add(loginformpanel);
        setSize(600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("SignUp to E-Trade");
        btn_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Giriş başarılı olacak mı acabna");
            }
        });
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showPasswordCheckBox.isSelected())
                {
                    showPasswordCheckBox.setText("hide password");
                    edtxt_signup_password.setEchoChar((char).0);
                }
                else
                {
                    showPasswordCheckBox.setText("show password");
                    edtxt_signup_password.setEchoChar('*');
                }
            }
        });
        btn_already_signed_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                show(false);




                new LoginForm().setVisible(true);
            }
        });
    }
}
