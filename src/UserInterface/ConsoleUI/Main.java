package UserInterface.ConsoleUI;


import Bussines.abstracts.UserService;
import Bussines.concretes.UserManager;
import Core.concretes.JCheckEmailServiceAdapter;
import Core.concretes.JLoggerAdapter;
import Core.concretes.JMailTransferManagerOutSourceServiceAdapter;
import Core.concretes.JValidatorAdapter;
import DataAccessLayer.Hibernate.HibernateUserDal;
import Entities.concretes.TestingDataBase;
import Entities.concretes.User;
import OutSourceService.JValidator.cocretes.JValidatorRules;
import UserInterface.SwingUI.SignUpForm;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JValidatorAdapter jValidatorAdapter= new JValidatorAdapter();

        UserService userService= new UserManager(
          new JLoggerAdapter(),
          jValidatorAdapter,
          new JCheckEmailServiceAdapter(),
          new HibernateUserDal(),
          new JMailTransferManagerOutSourceServiceAdapter()
        );

        User user= new User(1,"hakan","PEKER","eflatun@8gmail.com","1235556","ERKEK");

        userService.add(user);


        for(String s: TestingDataBase.createdLogList2)
        {
            System.out.println(s);
        }

        System.out.println("*******************");

        for(User user1:TestingDataBase.createdUserList)
        {
            System.out.println(user.toString());
        }

/*


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUpForm().setVisible(true);
            }
        });

*/




    }
}
