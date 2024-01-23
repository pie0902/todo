package com.todolist.todo_list.controller;

import com.todolist.todo_list.dto.TodoRequestDto;
import com.todolist.todo_list.dto.TodoResponsDto;
import com.todolist.todo_list.entity.TodoItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoApiController {
    private final JdbcTemplate jdbcTemplate;

    public TodoApiController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/todos")
    public TodoResponsDto createTodo(@RequestBody TodoRequestDto requestDto) {
        TodoItem newTodo = new TodoItem(requestDto);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO todolist (title, content) VALUES (?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newTodo.getTitle());
            preparedStatement.setString(2, newTodo.getContent());
            return preparedStatement;
        }, keyHolder);
        Long id = keyHolder.getKey().longValue();
        newTodo.setId(id);
        TodoResponsDto todoResponsDto = new TodoResponsDto(newTodo);

        return todoResponsDto;
        }
    @GetMapping("/todos")
    public List<TodoResponsDto> getTodos() {
        String sql = "SELECT * FROM todolist";
        return jdbcTemplate.query(sql, new RowMapper<TodoResponsDto>() {
            @Override
            public TodoResponsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long id = rs.getLong("id");
                String title = rs.getNString("title");
                String content = rs.getString("content");
                String manager = rs.getString("manager");
                Date date = new Date(rs.getTimestamp("date").getTime());
                return new TodoResponsDto(id, title, content, manager, date);
            }
        });
    }
    @PutMapping("todos/{id}")
    public Long update(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
        TodoItem todoItem = findById(id);
        if (todoItem != null) {
            String sql = "UPDATE todolist SET title = ?, content = ? WHERE id = ?";
            jdbcTemplate.update(sql, requestDto.getTitle(), requestDto.getContent(), id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 할 일은 존재하지 않습니다.");
        }
    }
    @DeleteMapping("todos/{id}")
    public Long delete(@PathVariable Long id) {
        TodoItem todoItem = findById(id);
        if (todoItem != null) {
            String sql = "DELETE FROM todolist WHERE id = ?";
            jdbcTemplate.update(sql, id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 할 일은 존재하지 않습니다.");
        }
    }



    private TodoItem findById(Long id){
        String sql = "SELECT * FROM todolist WHERE id = ?";
        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                TodoItem todoItem = new TodoItem();
                todoItem.setId(resultSet.getLong("id"));
                todoItem.setTitle(resultSet.getString("title"));
                todoItem.setContent(resultSet.getString("content"));
                todoItem.setManager(resultSet.getString("manager"));
                todoItem.setPassword(resultSet.getString("password"));
                todoItem.setDate(resultSet.getTimestamp("date")); // java.sql.Timestamp -> java.util.Date 변환
                return todoItem;
            } else {
                return null;
            }
        }, id);
    }

    }
