package com.lokesh.taskservice.controller;

import com.lokesh.taskservice.module.Task;
import com.lokesh.taskservice.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping(value = "/tasks", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Task> getAllTasks() {
        log.info("getting all tasks...");
        return this.taskService.getAllTasks();
    }

    @GetMapping(value = "/{emailId}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Task> getTasksByEmailId(@PathVariable("emailId") String emailId) {
//        return this.taskService.getTasksByUserId(id);
        return this.taskService.getTasksByEmailId(emailId);
    }

    @PostMapping()
    public Mono<Task> saveTask(@RequestBody Task task) {
        return this.taskService.save(task);
    }
}
