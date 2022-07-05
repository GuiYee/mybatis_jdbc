package com.sunwei.jdbc.service;

import com.sunwei.jdbc.dao.UserDao;
import com.sunwei.jdbc.pojo.User;

import java.util.List;

public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao ) {
        this.userDao = userDao;
    }
    public List<User> findUserByAge(int age) {
        return userDao.findUserByAge(age);
    }
}
