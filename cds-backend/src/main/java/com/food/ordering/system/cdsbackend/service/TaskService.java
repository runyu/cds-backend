package com.food.ordering.system.cdsbackend.service;

import com.food.ordering.system.cdsbackend.exception.ResourceNotFoundException;
import com.food.ordering.system.cdsbackend.model.Task;
import com.food.ordering.system.cdsbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        return task;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Long id, Task taskUpdated) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        task.setTaskName(taskUpdated.getTaskName());
        task.setProjectName(taskUpdated.getProjectName());
        task.setAssignee(taskUpdated.getAssignee());
        task.setDue(taskUpdated.getDue());

        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        taskRepository.deleteById(id);
    }
}
