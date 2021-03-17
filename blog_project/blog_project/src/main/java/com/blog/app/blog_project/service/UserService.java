package com.blog.app.blog_project.service;

import com.blog.app.blog_project.entity.User;
import com.blog.app.blog_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }

    public User updateUser(User user) {
        User user1 = userRepository.findById(user.getUserId()).get();
        user1.setUserName(user.getUserName());
        userRepository.save(user1);
        return user1;
    }

    public boolean deleteUser(int userId) {
        User user = userRepository.findById(userId).get();
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
