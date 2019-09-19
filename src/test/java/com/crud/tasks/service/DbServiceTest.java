package com.crud.tasks.service;

import com.crud.tasks.domain.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private DbService dbService;

    @Test
    public void testGetAllTasks() {
        // Given

        // When
        List<Task> taskList = dbService.getAllTasks();

        // Then
        Assert.assertFalse(taskList.isEmpty());
    }

    @Test
    public void testCreateTask() {
        // Given
        Task task = new Task(1L, "Task", "Content");

        // When
        Task saveTask = dbService.saveTask(task);

        // Then
        Assert.assertEquals("Task", task.getTitle());
        Assert.assertEquals("Content", task.getContent());

        // CleanUp
        dbService.deleteTask(saveTask.getId());
    }
}
