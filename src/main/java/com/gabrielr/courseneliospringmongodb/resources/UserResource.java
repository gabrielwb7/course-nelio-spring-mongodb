package com.gabrielr.courseneliospringmongodb.resources;

import com.gabrielr.courseneliospringmongodb.domain.User;
import com.gabrielr.courseneliospringmongodb.dto.UserDTO;
import com.gabrielr.courseneliospringmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = service.findAll();
        List<UserDTO> usersDto = users.stream().map( x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(usersDto);
    }
}
