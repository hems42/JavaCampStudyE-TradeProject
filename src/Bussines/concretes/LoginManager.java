package Bussines.concretes;

import Bussines.abstracts.LoginService;
import Entities.concretes.User;

public class LoginManager implements LoginService {
    @Override
    public boolean signIn(User user) {
        return false;
    }

    @Override
    public boolean signUp(User user) {
        return false;
    }
}
