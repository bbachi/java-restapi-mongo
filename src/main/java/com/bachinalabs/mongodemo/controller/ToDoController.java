package com.bachinalabs.mongodemo.controller;

import com.bachinalabs.mongodemo.dto.TaskDTO;
import com.bachinalabs.mongodemo.entity.Todo;
import com.bachinalabs.mongodemo.links.TaskLinks;
import com.bachinalabs.mongodemo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RepositoryRestController
@RequestMapping("/todo/")
@RequiredArgsConstructor
public class ToDoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private TodoService taskService;

    @GetMapping(path = TaskLinks.TASKS)
    public ResponseEntity<?> getTasks() {
        List<Todo> todoList = taskService.getTasks();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping(path = TaskLinks.TASK)
    public ResponseEntity<?> getTask(@PathVariable("id") String taskId) {
        try {
            LOGGER.info("TasksController::: " + taskId);
            Todo task = taskService.getTask(taskId);

            return ResponseEntity.ok(task);
        }catch (RuntimeException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", exc);
        }
    }

    @PostMapping(path = TaskLinks.CREATE_TASK)
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO) {
        LOGGER.info("TasksController: " + taskDTO);
        Todo task = taskService.saveTask(taskDTO);

        return ResponseEntity.ok(task);
    }

    @PutMapping(path = TaskLinks.UPDATE_TASK)
    public ResponseEntity<?> updateTask(@RequestBody TaskDTO taskDTO) {
        LOGGER.info("TasksController: " + taskDTO);
        Todo task = taskService.updateTask(taskDTO);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping(path = TaskLinks.DELETE_TASK)
    public ResponseEntity<?> deleteTask(@PathVariable("id") String taskId) {
        LOGGER.info("TasksController: " + taskId);
        String result = taskService.deleteTask(taskId);

        return ResponseEntity.ok(result);
    }
}