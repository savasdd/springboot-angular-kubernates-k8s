package com.k8s.service;

import com.k8s.model.User;
import com.k8s.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserServiceImpl {

    @Autowired
    private UserRepository repository;

    public User getUser(User user) throws Exception {
        var users=repository.findByUsername(user.getUsername()).orElseThrow(()->new Exception("User Not Found!"));
        log.info("User: "+user.getUsername());

        if(user.getUsername().equals(users.getUsername()) && user.getPassword().equals(users.getPassword()))
            return users;
        else
            throw new Exception("User Not Found!");
    }
}
