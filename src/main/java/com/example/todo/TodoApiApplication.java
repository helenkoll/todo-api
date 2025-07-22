package com.example.todo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.todo.model.Todo;
import com.example.todo.services.TodoService;

@SpringBootApplication
public class TodoApiApplication implements CommandLineRunner {

    Logger log = LoggerFactory.getLogger(TodoApiApplication.class);
    
    private TodoService todoService;
    public static void main(String[] args) {
        SpringApplication.run(TodoApiApplication.class, args);
    }

    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    public Todo getTodoById(Long id) {
        return todoService.getTodoById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoService.createTodo(todo);
    }

    public Todo updateTodo(Long id, Todo updated) {
        return todoService.getTodoById(id);    }
    public void deleteTodo(Long id) {
        todoService.deleteTodo(id);
    }
    
    //adding logging 
    @Override
    public void run(String... args) throws Exception {
        System.out.println("This is a console message!");
        log.info("INFO:  This is an info message!");
        log.warn("WARMING: This is a warning message!");
        log.error("ERROR: This is an error message");
        log.debug("DEBUG: This is a debug message");
    }
}