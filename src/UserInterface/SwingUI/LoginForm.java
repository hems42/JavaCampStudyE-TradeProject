package UserInterface.SwingUI;

import Bussines.abstracts.LoginService;
import Bussines.abstracts.UserService;
import Bussines.concretes.LoginManager;
import Bussines.concretes.UserManager;
import Core.abstracts.CheckEmailService;
import Core.abstracts.EmailTransferService;
import Core.abstracts.LoggerService;
import Core.abstracts.ValidationService;
import Core.concretes.JCheckEmailServiceAdapter;
import Core.concretes.JLoggerAdapter;
import Core.concretes.JMailTransferManagerOutSourceServiceAdapter;
import Core.concretes.JValidatorAdapter;
import DataAccessLayer.Hibernate.HibernateUserDal;
import DataAccessLayer.abstracts.UserDal;
import Entities.concretes.TestingDataBase;
import Entities.concretes.User;

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


    /////
    private UserService userService;
    private UserDal userDal;
    private LoggerService loggerService;
    private ValidationService validationService;
    private CheckEmailService checkEmailService;
    private EmailTransferService emailTransferService;
    private LoginService loginService;


    public LoginForm()  {



        userDal=new HibernateUserDal();
        loggerService=new JLoggerAdapter();
        emailTransferService=new JMailTransferManagerOutSourceServiceAdapter();
        checkEmailService=new JCheckEmailServiceAdapter();
        validationService=new JValidatorAdapter();
        userService=new UserManager(loggerService,
                validationService,
                userDal

        );
        loginService=new LoginManager(userService,
                checkEmailService,
                emailTransferService,
                loggerService);



        add(loginform);
        setTitle("Login to E-Trade");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                User user= new User();
                user.seteMail(edtxt_login_email.getText());
                user.setPassword(edtxt_login_password.getText());


                if(loginService.signIn(user))
                {
                    JOptionPane.showMessageDialog(null,"Sisteme Giriş Başarıyla Tamamlanmıştır.");

                }
                else if(edtxt_login_email.getText().isEmpty() ||edtxt_login_password.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Kullanıcı Bilgilerini Giriniz.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Kullanıcı Kaydı Bulunamamıştır.");

                }

                System.out.println("\n****\n");
                for(String s: TestingDataBase.createdLogList2)
                {
                    System.out.println("Login Ekranı Loglar : "+s);
                }





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
