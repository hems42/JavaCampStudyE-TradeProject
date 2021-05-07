package DataAccessLayer.Hibernate;

import DataAccessLayer.abstracts.UserDal;
import Entities.concretes.TestingDataBase;
import Entities.concretes.User;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class HibernateUserDal implements UserDal {
    @Override
    public void add(User user) {

        TestingDataBase.createdUserList.add(user);

    }

    @Override
    public void delete(User user) {


        for(User user1:TestingDataBase.createdUserList)
        {
            if(user1==user)
            {
                TestingDataBase.createdUserList.remove(user1);
            }
        }

    }

    @Override
    public void update(User user) {
        for(User user1:TestingDataBase.createdUserList)
        {
            if(user1==user)
            {
                TestingDataBase.createdUserList.remove(user1);
                TestingDataBase.createdUserList.add(user);
            }
        }
    }

    @Override
    public User get(User user) {
        User userFound=null;
        for(User user1:TestingDataBase.createdUserList)
        {
            if(user1==user)
            {
             userFound=user1;
            }
        }

        return userFound;
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users =  new ArrayList<>();

        TestingDataBase.createdUserList.stream().forEach(user -> users.add(user));

        return users;
    }
}
