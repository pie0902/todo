package com.todolist.todo_list.controller;

import com.todolist.todo_list.dto.TodoResponsDto;
import com.todolist.todo_list.entity.TodoItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Controller
public class TodoController {
    private final JdbcTemplate jdbcTemplate;
    public TodoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    public String index(Model model){
        List<TodoResponsDto> todos = getTodos();
        model.addAttribute("todos", todos);
        model.addAttribute("todoItem", new TodoItem());
        return "todoForm";
    }

    private List<TodoResponsDto> getTodos() {
        String sql = "SELECT * FROM todolist";
        return jdbcTemplate.query(sql, new RowMapper<TodoResponsDto>() {
            @Override
            public TodoResponsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String password = rs.getString("password");
                String manager = rs.getString("manager");
                Date date = new Date(rs.getTimestamp("date").getTime());
                return new TodoResponsDto(id, password, title, content, manager, date);
            }
        });
    }

}