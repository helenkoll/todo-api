package com.example.todo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

public class TodoServiceTest {

    private TodoRepository todoRepository;
    private TodoService todoService;

@BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        todoRepository = mock(TodoRepository.class);
        todoService = new TodoService(todoRepository); // Inject mocked repository
    }

    @Test
    public void testGetAllTodos() {
        when(todoRepository.findAll()).thenReturn(Collections.emptyList());
        List<Todo> todos = todoService.getAllTodos();
        assertEquals(0, todos.size());
    }

    @Test
    public void testGetTodoById() {
        Todo mockTodo = new Todo();
        mockTodo.setId(1L);
        mockTodo.setTitle("Test");
        when(todoRepository.findById(1L)).thenReturn(Optional.of(mockTodo));

        Optional<Todo> result = todoService.getTodoById(1L);
        assertEquals("Test", result.get().getTitle());
    }

    @Test
    public void testCreateTodo() {
        Todo newTodo = new Todo();
        newTodo.setTitle("New Task");
        when(todoRepository.save(any(Todo.class))).thenReturn(newTodo);

        Todo created = todoService.createTodo(newTodo);
        assertEquals("New Task", created.getTitle());
    }// ta test na kaluptoun kaio xrhsths na kanei xaza 
}
