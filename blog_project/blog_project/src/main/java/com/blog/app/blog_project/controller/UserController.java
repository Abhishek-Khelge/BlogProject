package com.blog.app.blog_project.controller;

import com.blog.app.blog_project.entity.User;
import com.blog.app.blog_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int userId) {
        boolean flag = userService.deleteUser(userId);
        if (flag)
            return "user entry deleted";
        else
            return " deletion failed";
    }
}
