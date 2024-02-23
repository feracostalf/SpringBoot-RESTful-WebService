package com.example.webservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.webservice.user.User;

@Service
public interface UserService {
    
    public List<User> findAll();

    public User findOne(int id);

    public void removeById(int id);

    public User saveUser(User user);
}