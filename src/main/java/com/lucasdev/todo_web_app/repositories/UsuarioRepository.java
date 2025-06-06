package com.lucasdev.todo_web_app.repositories;

import com.lucasdev.todo_web_app.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

}
