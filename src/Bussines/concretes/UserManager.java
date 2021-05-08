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
    private UserDal userDal;

    public UserManager(LoggerService loggerService, ValidationService validationService, UserDal userDal) {
        this.loggerService = loggerService;
        this.validationService = validationService;
        this.userDal = userDal;
    }

    @Override
    public void add(User user) {
        if(isValidUser(user))
        {

            userDal.add(user);
            loggerService.logDatabase(user.getFullName()+ " kişisi başarıyla kaydedildi");

        }
        else
        {
            TestingDataBase.createdLogList2.add(user.getFullName()+ " isimli kullanıcı kaydı başarısız oldu.");
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
