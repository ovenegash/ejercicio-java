package cl.java.evaluation.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.java.evaluation.dao.UserDao;
import cl.java.evaluation.model.User;

@Repository
public class UserRepository {

    @Autowired
    UserDao userDao;

    public List<User> getAllUser() {
        return userDao.findAll();
    }

    public List<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User save(User user) {
        return userDao.save(user);
    }
}
