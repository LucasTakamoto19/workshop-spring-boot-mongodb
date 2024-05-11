package com.lucastakamoto.workshopmongo.controller;

import com.lucastakamoto.workshopmongo.domain.Usuario;
import com.lucastakamoto.workshopmongo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<Usuario>> findAll(){
        List<Usuario> list = usuarioService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
