package com.lucastakamoto.workshopmongo.service;

import com.lucastakamoto.workshopmongo.domain.Post;
import com.lucastakamoto.workshopmongo.domain.User;
import com.lucastakamoto.workshopmongo.dto.UserDTO;
import com.lucastakamoto.workshopmongo.exception.ObjectNotFoundException;
import com.lucastakamoto.workshopmongo.repository.PostRepository;
import com.lucastakamoto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTittle(String text){
        return repo.findByTittleContaining(text);
    }
}