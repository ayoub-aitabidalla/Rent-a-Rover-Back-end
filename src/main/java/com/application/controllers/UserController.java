package com.application.controllers;

import com.application.entities.User;
import com.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/add")
    public void createUser(@RequestBody User user)
    {
        userService.createUser(user);
    }
    @GetMapping("/users")
    public List<User> getUser()
    {
        return userService.getUsers();
    }
    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable String id)
    {
        return  userService.getUserByUserId(id);

    }
    @PutMapping(path = "/user/{id}")
    public User updateUser(@PathVariable String id,@RequestBody User user)
    {
        return userService.updateUser(id, user);
    }
    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable String id)
    {
        userService.deleteUser(id);

    }
}
