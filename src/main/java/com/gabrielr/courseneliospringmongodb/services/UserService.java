package com.gabrielr.courseneliospringmongodb.services;

import com.gabrielr.courseneliospringmongodb.domain.User;
import com.gabrielr.courseneliospringmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
