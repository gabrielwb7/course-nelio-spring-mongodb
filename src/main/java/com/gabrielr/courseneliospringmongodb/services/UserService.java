package com.gabrielr.courseneliospringmongodb.services;

import com.gabrielr.courseneliospringmongodb.domain.User;
import com.gabrielr.courseneliospringmongodb.repositories.UserRepository;
import com.gabrielr.courseneliospringmongodb.services.exceptions.ObjectNotFoundException;
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

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("O usuario com esse id " + id + " não existe"));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(String id) {
        User user = findById(id);
        repository.deleteById(user.getId());
    }

    public User update(String id, User build) {
        User user = findById(id);
        user.setName(build.getName());
        user.setEmail(build.getEmail());

        return repository.save(user);
    }
}
