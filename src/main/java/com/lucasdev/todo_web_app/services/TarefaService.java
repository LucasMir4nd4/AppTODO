package com.lucasdev.todo_web_app.services;

import com.lucasdev.todo_web_app.entities.Tarefa;
import com.lucasdev.todo_web_app.repositories.TarefaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    public List<Tarefa> createTarefa(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        return listTarefa();
    }
    public List<Tarefa> listTarefa() {
        Sort sort = Sort.by(Sort.Direction.DESC, "dataCriacao");
        return tarefaRepository.findAll(sort);
    }
    public List<Tarefa> updateTarefa(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
        return listTarefa();
    }
    public List<Tarefa> deleteTarefa(Long id) {
        tarefaRepository.deleteById(id);
        return listTarefa();
    }



}
