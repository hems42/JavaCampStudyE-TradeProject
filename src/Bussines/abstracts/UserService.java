package Bussines.abstracts;

import Entities.concretes.User;


public interface UserService extends BaseCrudService<User> {

    boolean isValidUser(User user);
}
