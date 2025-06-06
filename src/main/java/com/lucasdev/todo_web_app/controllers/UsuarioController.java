package com.lucasdev.todo_web_app.controllers;

import com.lucasdev.todo_web_app.entities.Usuario;
import com.lucasdev.todo_web_app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> findAll(){
        List<Usuario> result = repository.findAll();
        return result;
    }

}
