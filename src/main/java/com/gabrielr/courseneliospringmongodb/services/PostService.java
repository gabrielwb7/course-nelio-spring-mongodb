package com.gabrielr.courseneliospringmongodb.services;

import com.gabrielr.courseneliospringmongodb.domain.Post;
import com.gabrielr.courseneliospringmongodb.domain.User;
import com.gabrielr.courseneliospringmongodb.repositories.PostRepository;
import com.gabrielr.courseneliospringmongodb.repositories.UserRepository;
import com.gabrielr.courseneliospringmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("O post com esse id " + id + " não existe"));
    }
}
