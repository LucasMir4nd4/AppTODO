package com.lucasdev.todo_web_app.db;

import com.lucasdev.todo_web_app.entities.Tarefa;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BancoDeDados {

    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void insertTarefa(boolean concluida,String titulo) {
        String sql = "INSERT INTO tb_task (concluida,titulo) VALUES (?,?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBoolean(1, concluida);
            stmt.setString(2, titulo);
            stmt.executeUpdate();

            System.out.println("tarefa inserida com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tarefa> getTarefas() {
        String sql = "SELECT * FROM tb_task";
        List<Tarefa> tarefas = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getLong("id"));
                tarefa.setConcluida(rs.getBoolean("concluida"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefas;
    }

}
