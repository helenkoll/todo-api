package com.example.todo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

@SpringBootApplication
public class TodoApiApplication implements CommandLineRunner {

    Logger log = LoggerFactory.getLogger(TodoApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TodoApiApplication.class, args);
    }

    @Autowired
    private TodoRepository todoRepository;//to call only service when need be 

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updated) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(updated.getTitle());
            todo.setCompleted(updated.isCompleted());
            return todoRepository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
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