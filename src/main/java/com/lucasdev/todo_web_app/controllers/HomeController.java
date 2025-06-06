package com.lucasdev.todo_web_app.controllers;


import com.lucasdev.todo_web_app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }

}
