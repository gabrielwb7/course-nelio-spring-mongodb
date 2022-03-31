package com.gabrielr.courseneliospringmongodb.resources;

import com.gabrielr.courseneliospringmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria", "maria@email.com");
        User alex = new User("2", "Alex", "alex@email.com");

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(users);
    }
}
