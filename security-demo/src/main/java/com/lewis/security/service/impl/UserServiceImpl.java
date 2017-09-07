package com.lewis.security.service.impl;

import com.lewis.security.domain.User;
import com.lewis.security.repository.VirtualDB;
import com.lewis.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<User> queryAllUsers() {
        return VirtualDB.getUsers();
    }

    @Override
    public User queryUser() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
