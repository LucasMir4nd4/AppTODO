package com.lucasdev.todo_web_app.repositories;

import com.lucasdev.todo_web_app.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> { }
