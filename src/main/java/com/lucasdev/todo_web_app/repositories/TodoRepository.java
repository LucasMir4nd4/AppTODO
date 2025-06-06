package com.lucasdev.todo_web_app.repositories;

import com.lucasdev.todo_web_app.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
