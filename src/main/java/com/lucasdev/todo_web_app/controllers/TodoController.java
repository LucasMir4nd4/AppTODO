package com.lucasdev.todo_web_app.controllers;

import com.lucasdev.todo_web_app.entities.Todo;
import com.lucasdev.todo_web_app.services.TodoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

//    @GetMapping("/home")
//    public String home(){
//        return "home";
//    }

    @PostMapping("/create")
    public String create(@ModelAttribute Todo todo, Model model) {

        List<Todo> listaAtualizada =  todoService.create(todo);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String list(Todo todo, Model model) {
        model.addAttribute("todos", todoService.list());
        return "home";
    }

    @PutMapping
    public List<Todo> update(@ModelAttribute Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> detete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }

}
