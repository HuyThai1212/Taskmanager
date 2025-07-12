package com.taskmanager.taskmanager_api.service;

import com.taskmanager.taskmanager_api.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private int currentId = 1;

    public List<Task> getAll() {
        return new ArrayList<>(taskMap.values());
    }

    public Task add(Task task) {
        task.setId(currentId++);
        taskMap.put(task.getId(), task);
        return task;
    }

    public Task update(int id, Task task) {
        if (taskMap.containsKey(id)) {
            task.setId(id);
            taskMap.put(id, task);
            return task;
        }
        return null;
    }

    public boolean delete(int id) {
        return taskMap.remove(id) != null;
    }
}