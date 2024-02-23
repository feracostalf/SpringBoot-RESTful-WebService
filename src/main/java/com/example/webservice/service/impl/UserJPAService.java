package com.example.webservice.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webservice.exception.UserNotFoundException;
import com.example.webservice.repository.UserJPARespository;
import com.example.webservice.service.UserService;
import com.example.webservice.user.User;


@Component
public class UserJPAService implements UserService{

    @Autowired
    UserJPARespository jpaRespository;

    public List<User> findAll(){
        return jpaRespository.findAll();
    }

    public User findOne(int id) {
        Optional<User> user=jpaRespository.findById(id);
        if (!user.isPresent()) throw new UserNotFoundException("Not found: "+id);

        return user.get();
    }

    public void removeById(int id) {
        jpaRespository.deleteById(id);
    }

    public User saveUser(User user){
        return jpaRespository.save(user);
    }
}
