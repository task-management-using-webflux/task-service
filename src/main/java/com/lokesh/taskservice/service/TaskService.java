package com.lokesh.taskservice.service;

import com.lokesh.taskservice.module.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {
    Flux<Task> getAllTasks();

    Mono<Task> getTasksByUserId(String id);

    Mono<Task> save(Task task);

    Mono<Task> getTasksByEmailId(String id);
}
