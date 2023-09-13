package com.example.webservice.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDAOService {
    //Static List
    private static List<User> users=new ArrayList<>();
    private static int countUsers=0;

    static{
        users.add(new User(++countUsers, "Fernando Acosta", LocalDate.now().minusYears(27)));
        users.add(new User(++countUsers, "Hector Garcia", LocalDate.now().minusYears(40)));
        users.add(new User(++countUsers, "Jorge Hernandez", LocalDate.now().minusYears(22)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
        Predicate<User> predicate = user -> user.getId().equals(id); 
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User saveUser(User user){
        user.setId(++countUsers);
        users.add(user);
        return user;
    }
}
