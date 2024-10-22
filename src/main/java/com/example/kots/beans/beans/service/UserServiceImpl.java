package com.example.kots.beans.beans.service;

import com.example.kots.beans.beans.dao.UserDao;
import com.example.kots.beans.beans.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }


    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    @Override
    public void updateUser(int id,User user) {
        userDao.updateUser(id, user);
    }

}
