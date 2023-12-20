package com.lucastakamoto.workshopmongo.resources;

import com.lucastakamoto.workshopmongo.domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity <List<Usuario>> findAll(){
        Usuario maria = new Usuario("1", "Maria Brown", "mariabrown@gmail.com");
        Usuario alex = new Usuario("2", "Alex Green", "alexgreen@gmail.com");

        List<Usuario> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
