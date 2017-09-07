package com.lewis.security.service;

import com.lewis.security.domain.User;

import java.util.List;

public interface UserService {

    List<User>  queryAllUsers();

    User queryUser();

    boolean deleteUser(int id);

    boolean updateUser(User user);
}
