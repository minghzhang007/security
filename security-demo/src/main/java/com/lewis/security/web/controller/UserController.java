package com.lewis.security.web.controller;

import com.lewis.security.domain.User;
import com.lewis.security.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public List<User> queryUsers() {

        return userService.queryAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User queryUser(@PathVariable(name = "id") int id) {
        List<User> users = userService.queryAllUsers();
        return users.stream().filter(user -> user.getId() == id).findAny().orElseGet(() -> new User());
    }


    @PostMapping
    public User addUser(@RequestBody User user) {
        List<User> users = userService.queryAllUsers();
        user.setId(200);
        users.add(user);
        System.out.println("users: " + users);
        return user;
    }

    @PutMapping
    public User updateUser(User user) {
        System.out.println(user);
        return user;
    }


}
