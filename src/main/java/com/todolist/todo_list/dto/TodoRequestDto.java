package com.todolist.todo_list.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
public class TodoRequestDto {
    private String title;
    private String content;
    public TodoRequestDto(String title,String content){
        this.title = title;
        this.content = content;
    }
}
