package com.lucastakamoto.workshopmongo.service;

import java.util.List;

import com.lucastakamoto.workshopmongo.domain.User;
import com.lucastakamoto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}