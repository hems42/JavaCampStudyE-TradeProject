package UserInterface.SwingUI;

import Entities.concretes.TestingDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailForm extends JFrame{




    public EmailForm()  {
        setSize(800,250);
        add(emailform);
        setTitle("Register Your Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_email_onay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestingDataBase.createdLogList2.add("Kayıt Başarıyla Tamamlanmıştır Tebrikler");
                JOptionPane.showMessageDialog(null,"Hesabınız onaylanmıştır....");

                setVisible(false);
                new LoginForm().setVisible(true);

                System.out.println("*\n******");

                for(String s:TestingDataBase.createdLogList2)
                {
                    System.out.println("Email doğrulaması sonrası loglar : "+s);
                }

            }
        });

    }

    private JPanel emailform;
    private JButton btn_email_onay;
    private JLabel txt_email_message;
    private JButton LOGINEKRANIButton;


}
