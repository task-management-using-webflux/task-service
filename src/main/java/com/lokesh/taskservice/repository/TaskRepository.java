package com.lokesh.taskservice.repository;

import com.lokesh.taskservice.module.Task;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TaskRepository extends ReactiveMongoRepository<Task, String> {
    @Query("{emailId:?0}")
    Mono<Task> findByEmailId(String emailId);
}
