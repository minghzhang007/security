package com.lewis.security.repository;

import com.google.common.collect.Lists;
import com.lewis.security.domain.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VirtualDB {

    public static List<User> getUsers() {
        ArrayList<User> users = Lists.newArrayList();
        for (int i = 1; i <= 100; i++) {
            users.add(new User(i, "name_" + i, "password_" + i, new Date()));
        }
        return users;
    }
}
