package com.todolist.todo_list.entity;


import com.todolist.todo_list.dto.TodoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
    private Long id;
    private String title;
    private String content;
    private String manager;
    private String password;
    private Date date;
public TodoItem(TodoRequestDto requestDto){
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.manager = "me";
    this.password = "123";
    this.date = new Date();
}
    @Override
    public String toString() {
        return id+title+content+manager+date;
    }
}

