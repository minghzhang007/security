package com.lewis.security.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lewis.security.domain.User;
import com.lewis.security.domain.View;
import com.lewis.security.dto.UserQueryCondtion;
import com.lewis.security.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    @JsonView(View.Summary.class)
    public List<User> queryUsers(UserQueryCondtion queryCondtion, Pageable pageable) {

        List<User> users = userService.queryAllUsers();
        return users.stream().filter(user -> user.getName().equals(queryCondtion.getName() )).collect(Collectors.toList());
    }

    // \d+传的id必须为数字
    @GetMapping(value = "/{id:\\d+}")
    @JsonView(View.DetailSummary.class)
    public User queryUser(@PathVariable(value = "id") String idxxx) {
        List<User> users = userService.queryAllUsers();
        return users.stream().filter(user -> user.getId().equals(Integer.parseInt(idxxx))).findAny().orElseGet(() -> new User());
    }


    @PostMapping
    @JsonView(View.Summary.class)
    public User addUser(@Valid @RequestBody User user, BindingResult errors) {
        List<User> users = userService.queryAllUsers();
        user.setId(200);
        users.add(user);
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(ex -> System.out.println(ex.getDefaultMessage()));
        }
        return user;
    }

    @PutMapping(value = "/{id://d+}")
    public User updateUser(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @DeleteMapping(value = "/{id://d+}")
    @JsonView
    public String deleteUser(@PathVariable String id){
        String resp ="删除："+id;
        return resp;
    }


}
