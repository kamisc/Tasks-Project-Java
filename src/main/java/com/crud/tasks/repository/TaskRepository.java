package com.crud.tasks.repository;

import com.crud.tasks.domain.task.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author Kamil Seweryn
 */

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();

    @Override
    Task save(Task task);

    @Override
    Optional<Task> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
