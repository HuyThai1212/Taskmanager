package com.taskmanager.taskmanager_api.controller;

import com.taskmanager.taskmanager_api.model.Task;
import com.taskmanager.taskmanager_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.add(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        boolean deleted = taskService.delete(id);
        return deleted ? "Deleted" : "Not found";
    }
}
