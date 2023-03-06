package com.lokesh.taskservice.service.impl;

import com.lokesh.taskservice.module.Task;
import com.lokesh.taskservice.repository.TaskRepository;
import com.lokesh.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Flux<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }
    @Override
    public Mono<Task> getTasksByUserId(String id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public Mono<Task> save(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public Mono<Task> getTasksByEmailId(String id) {
        return this.taskRepository.findByEmailId(id);
    }
}
