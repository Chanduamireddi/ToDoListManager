package com.todomanagerlist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();
    private int taskId = 1;

    public Task add(String description, String status) {
        Task newTask = new Task(taskId++, description, status);
        tasks.add(newTask);
        return newTask;
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> getById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    public boolean delete(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public boolean updateStatus(int id, String status) {
        Optional<Task> taskOpt = getById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setStatus(status);
            return true;
        }
        return false;
    }
}
