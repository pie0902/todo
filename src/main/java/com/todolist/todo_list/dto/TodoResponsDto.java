package com.todolist.todo_list.dto;

import com.todolist.todo_list.entity.TodoItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@AllArgsConstructor
@Getter
public class TodoResponsDto {
    private Long id;
    private String title;
    private String content;
    private String password;
    private String manager;
    private Date date;

    public TodoResponsDto(TodoItem todoItem) {
        this.id = todoItem.getId();
        this.title = todoItem.getTitle();
        this.content = todoItem.getContent();
        this.password = todoItem.getPassword();
        this.manager = todoItem.getManager();
        this.date = todoItem.getDate();
    }
}
