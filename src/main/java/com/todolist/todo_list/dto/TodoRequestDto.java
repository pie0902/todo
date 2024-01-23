package com.todolist.todo_list.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
public class TodoRequestDto {
    private String title;
    private String content;
    private String password;
    public TodoRequestDto(String title,String content,String password){
        this.title = title;
        this.content = content;
        this.password = password;
    }
}
