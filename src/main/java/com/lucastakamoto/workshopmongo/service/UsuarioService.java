package com.lucastakamoto.workshopmongo.service;

import com.lucastakamoto.workshopmongo.domain.Usuario;
import com.lucastakamoto.workshopmongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
}
