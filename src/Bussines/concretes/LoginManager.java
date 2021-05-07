package Bussines.concretes;

import Bussines.abstracts.LoginService;
import Bussines.abstracts.UserService;
import Core.abstracts.CheckEmailService;
import Core.abstracts.EmailTransferService;
import Core.abstracts.LoggerService;
import Core.abstracts.ValidationService;
import DataAccessLayer.abstracts.UserDal;
import Entities.concretes.User;

public class LoginManager implements LoginService {

    private UserService userService;

    public LoginManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean signIn(User user) {



        return false;
    }

    @Override
    public boolean signUp(User user) {
        return false;
    }
}
