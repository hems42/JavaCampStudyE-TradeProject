package Bussines.concretes;

import Bussines.abstracts.LoginService;
import Bussines.abstracts.UserService;
import Core.abstracts.CheckEmailService;
import Core.abstracts.EmailTransferService;
import Core.abstracts.LoggerService;
import Core.abstracts.ValidationService;
import DataAccessLayer.abstracts.UserDal;
import Entities.concretes.TestingDataBase;
import Entities.concretes.User;

public class LoginManager implements LoginService {

    private UserService userService;
    private CheckEmailService checkEmailService;
    private EmailTransferService emailTransferService;
    private LoggerService loggerService;
    public LoginManager(UserService userService,
                        CheckEmailService checkEmailService,
                        EmailTransferService emailTransferService,
                        LoggerService loggerService) {
        this.userService = userService;
        this.checkEmailService = checkEmailService;
        this.emailTransferService = emailTransferService;
        this.loggerService=loggerService;
    }

    @Override
    public boolean signUp(User user) {

        boolean result=true;

        if(checkEmailService.isValidMail(user.geteMail()))
        {

            if(!checkEmailService.isAlreadyUsedMail(user.geteMail()))
            {


                userService.add(user);
                emailTransferService.sendMail(user.getFullName()+ " kişisi başarıyla kaydedildi mesajı "
                        + user.geteMail()+ " mail adresine  gönderildi.\n Hesaba gelen link ile üyeliğinizi tamamlayın lütfen... ",user.geteMail());
                TestingDataBase.createdEmailList.add(user.geteMail());
                loggerService.logDatabase(user.getFullName()+ " kişisi sisteme kaydedildi.");

            }
            else {

               result=false;
                TestingDataBase.createdLogList.put(TestingDataBase.TAG_EMAIL_EXIST,"Bu Email Hesabı ile Daha Önce Kayıt Yapılmış!!! ");
                TestingDataBase.createdLogList2.add("Bu Email Hesabı ile Daha Önce Kayıt Yapılmış!!! ");
            }

        }
        else
        {
            result=false;
            TestingDataBase.createdLogList.put(TestingDataBase.TAG_EMAIL_EXIST,"Geçerli Bir Email Hesabı Giriniz!!! ");
            TestingDataBase.createdLogList2.add("Geçerli Bir Email Hesabı Giriniz!!! ");
        }


        return result;
    }

    @Override
    public boolean signIn(User user) {
        boolean result=false;

        for(User userr:TestingDataBase.createdUserList)
        {
            if(userr.geteMail().equals(user.geteMail()))
            {
                result=true;

                TestingDataBase.createdLogList2.add(user.getFullName()+ " sisteme giriş yaptı.");
                loggerService.logDatabase(user.getFullName()+ " kişisi sisteme giriş yaptı");

                break;
            }
        }

        if(result==false)
        {
            TestingDataBase.createdLogList2.add(user.getFullName()+ " sisteme girişinde hata oluştu.");
            loggerService.logDatabase(user.getFullName()+ " sisteme girişinde hata oluştu.");



        }


        return result;
    }
}
