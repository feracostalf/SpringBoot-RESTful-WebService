package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webservice.user.User;

public interface UserJPARespository extends JpaRepository<User,Integer>{

}
