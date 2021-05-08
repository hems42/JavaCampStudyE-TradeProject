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
import OutSourceService.JValidator.cocretes.JValidatorRules;

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
    private JButton onaylamaEkranıButton;


    /////
    private UserService userService;
    private UserDal userDal;
    private LoggerService loggerService;
    private ValidationService validationService;
    private CheckEmailService checkEmailService;
    private EmailTransferService emailTransferService;
    private LoginService loginService;



    public SignUpForm(){


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




        add(loginformpanel);
        setSize(600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("SignUp to E-Trade");



        btn_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(validationService.isValidName(edtxt_name.getText()))
              {

                  if(validationService.isValidSurName(edtxt_surname.getText()))
                  {

                      if(validationService.isValidEmailFormat(edtxt_signup_email.getText()))
                      {
                          if(checkEmailService.isValidMail(edtxt_signup_email.getText()))
                          {
                              if(!checkEmailService.isAlreadyUsedMail(edtxt_signup_email.getText()))
                          {
                                     if(validationService.isValidPassword(edtxt_signup_password.getText()))


                                     {

                              if(  loginService.signUp(new User(1,
                                      edtxt_name.getText(),
                                      edtxt_surname.getText(),
                                      edtxt_signup_email.getText(),
                                      edtxt_signup_password.getText(),
                                      "****")))
                              {
                                  fastDialog(edtxt_name.getText()+ " "+ edtxt_surname.getText()+
                                          " isimli kullanıcı başarıyla eklendi Belirtilen e mail adresine gönderilen link" +
                                          " ile  aydı tamamlayabilirsiniz!!!" );

                                  setVisible(false);
                                  new EmailForm().setVisible(true);

                                  for(String s:TestingDataBase.createdLogList2)
                                  {
                                      System.out.println("SignUp Ekranı Loglar: "+s);
                                  }

                                  System.out.println("****");

                                  for(User user:TestingDataBase.createdUserList)
                                  {
                                      System.out.println("SignUp Ekranı Oluşturulan Kişiler Listesi : "+user.toString());
                                  }
                              }

                              else {
                                  fastDialog(edtxt_name.getText()+ " "+ edtxt_surname.getText()+
                                          " isimli kullanıcı eklenirken bir hata meydane geldi  lütfen" +
                                          " daha sonra tekrar deneyiniz...");


                                  for(String s:TestingDataBase.createdLogList2)
                                  {
                                      System.out.println("SignUp Ekranı Loglar: "+s);
                                  }

                                  System.out.println("****");

                                  for(User user:TestingDataBase.createdUserList)
                                  {
                                      System.out.println("SignUp Ekranı Oluşturulan Kişiler Listesi : "+user.toString());
                                  }
                              }



                          }
                          else
                          {
                              fastDialog("parola alanı en az altı karakter olmalıdır...");
                          }
                          }
                              else
                              {
                                  fastDialog("Bu E-mail adresi ile daha önce kayıt yapılmış!!");

                              }

                          }


                          else
                          {
                              fastDialog("lütfen doğrulanmış bir email adresi  giriniz!!");
                          }




                      }
                      else
                      {

                          fastDialog("lütfen geçerli bir email formatı giriniz!!");

                      }


                  }
                  else
                  {
                      fastDialog("soy isim alanı en az iki  karakter olmalı ve  rakam vs içermemelidir...");
                  }

              }
              else
              {
                  fastDialog("isim alanı en az iki  karakter olmalı ve  rakam vs içermemelidir...");
              }
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


   private void fastDialog(String s)
    {
        JOptionPane.showMessageDialog(null,s);
    }
}
