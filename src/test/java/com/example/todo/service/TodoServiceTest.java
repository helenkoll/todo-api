package com.example.todo.service;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.services.TodoService;

public class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTodos() {
        Todo todo = new Todo("Test","Test Description",false);

        when(todoRepository.findAll()).thenReturn(List.of(todo));

        List<Todo> todos = todoService.getAllTodos();
        assertEquals(1, todos.size());
        assertEquals("Test", todos.get(0).getTitle());
    }

    @Test
    public void testGetTodoById() {
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Test");

        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        Todo result = todoService.getTodoById(1L);
        assertNotNull(result);
        assertEquals("Test", result.getTitle());
    }

    @Test
    public void testCreateTodo() {
        Todo todo = new Todo();
        todo.setTitle("Test");

        Todo savedTodo = new Todo();
        savedTodo.setId(1L);
        savedTodo.setTitle("Test");

        when(todoRepository.save(todo)).thenReturn(savedTodo);

        Todo result = todoService.createTodo(todo);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
}
