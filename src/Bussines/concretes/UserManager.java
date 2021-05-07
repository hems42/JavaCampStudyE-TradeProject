package Bussines.concretes;


import Bussines.abstracts.UserService;
import Core.abstracts.CheckEmailService;
import Core.abstracts.EmailTransferService;
import Core.abstracts.LoggerService;
import Core.abstracts.ValidationService;
import DataAccessLayer.abstracts.UserDal;
import Entities.concretes.TestingDataBase;
import Entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {

    private LoggerService loggerService;
    private ValidationService validationService;
    private CheckEmailService checkEmailService;
    private UserDal userDal;
    private EmailTransferService emailTransferService;

    public UserManager(LoggerService loggerService,
                       ValidationService validationService,
                       CheckEmailService checkEmailService,
                       UserDal userDal,
                       EmailTransferService emailTransferService) {
        this.loggerService = loggerService;
        this.validationService = validationService;
        this.checkEmailService = checkEmailService;
        this.userDal = userDal;
        this.emailTransferService = emailTransferService;
    }

    @Override
    public void add(User user) {
        if(isValidUser(user))
        {
            if(checkEmailService.isValidMail(user.geteMail()))
            {

                if(checkEmailService.isAlreadyUsedMail(user.geteMail()))
                {

                    userDal.add(user);
                    loggerService.logDatabase(user.getFullName()+ " kişisi başarıyla kaydedildi");
                    emailTransferService.sendMail(user.getFullName()+ " kişisi başarıyla kaydedildi mesajı\n"
                    + user.geteMail()+ " mail adresine  gönderilen link ile üyeliğinizi tamamlayın lütfen... ",user.geteMail());
                    TestingDataBase.createdEmailList.add(user.geteMail());

                }
                else {
                    TestingDataBase.createdLogList.put(TestingDataBase.TAG_EMAIL_EXIST,"Bu Email Hesabı ile Daha Önce Kayıt Yapılmış!!! ");

                }

            }
            else
            {
                TestingDataBase.createdLogList.put(TestingDataBase.TAG_EMAIL_EXIST,"Geçerli Bir Email Hesabı Giriniz!!! ");
            }
        }
    }

    @Override
    public void delete(User user) {

        if(isValidUser(user))
        {
            userDal.delete(user);
        }
    }

    @Override
    public void update(User user) {

        if(isValidUser(user))
        {
            userDal.update(user);
        }
    }

    @Override
    public User get(User user) {
        return userDal.get(user);
    }

    @Override
    public List<User> getAll() {
        return userDal.getAll();
    }





    @Override
    public boolean isValidUser(User user) {
        boolean result=true;

        if(validationService.isValidName(user.getName()))
        {

            if(validationService.isValidSurName(user.getSurname()))
            {


                if(validationService.isValidEmailFormat(user.geteMail()))
                {



                    if(validationService.isValidPassword(user.getPassword()))
                    {



                    }
                    else {
                        result=false;
                        TestingDataBase.createdLogList
                                .put(TestingDataBase.TAG_PASSWORD,"Geçerli Bir Parola  Girin!!!");
                    }


                }
                else {
                    result=false;
                    TestingDataBase.createdLogList
                            .put(TestingDataBase.TAG_EMAIL_FORMAT,"Geçerli Bir E mail adresi Girin!!!");
                }


            }
            else {
                result=false;
                TestingDataBase.createdLogList
                        .put(TestingDataBase.TAG_SURNAME,"Geçerli Bir Soy isim Girin!!!");
            }

        }
        else {
            result=false;
            TestingDataBase.createdLogList
                    .put(TestingDataBase.TAG_NAME,"Geçerli Bir isim Girin!!!");
        }



        return result;
    }
}
