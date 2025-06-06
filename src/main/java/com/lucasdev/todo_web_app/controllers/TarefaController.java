package com.lucasdev.todo_web_app.controllers;

import com.lucasdev.todo_web_app.db.BancoDeDados;
import com.lucasdev.todo_web_app.entities.Tarefa;
import com.lucasdev.todo_web_app.repositories.TarefaRepository;
import com.lucasdev.todo_web_app.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    public TarefaController (TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/adicionarTarefa")
    public String adicionarTarefa(@RequestParam Tarefa tarefa , Model model){
        tarefaService.createTarefa(new Tarefa(tarefa.getTitulo(), false));
        System.out.println("Tarefa adicionada: " + tarefa);
        listarTarefas(model);
        return "redirect:/home"; // Redireciona para a página inicial após adicionar a tarefa
    }
    @GetMapping("/listarTarefas")
    public String listarTarefas(Model model) {
        tarefaService.listTarefa();
        return "redirect:/home";
    }
    @PutMapping("/atualizarTarefa")
    public String atualizarTarefa(@RequestParam Long id, @RequestParam boolean concluida, Model model) {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(id);
        tarefa.setConcluida(concluida);
        tarefaService.updateTarefa(tarefa);
        listarTarefas(model);
        return "redirect:/home"; // Redireciona para a página inicial após atualizar a tarefa
    }
    @RequestMapping("/removerTarefa")
    public String removerTarefa(@RequestParam Long id, Model model) {
        tarefaService.deleteTarefa(id);
        listarTarefas(model);
        return "redirect:/home"; // Redireciona para a página inicial após remover a tarefa
    }

}
