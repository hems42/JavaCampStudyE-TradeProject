package Bussines.abstracts;

import Entities.concretes.User;

public interface LoginService {

    boolean signIn(User user);
    boolean signUp(User user);
}
