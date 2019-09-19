package com.crud.tasks.mapper;

import com.crud.tasks.domain.task.Task;
import com.crud.tasks.domain.task.TaskDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * Author Kamil Seweryn
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    private Task task;
    private TaskDto taskDto;
    private List<Task> taskList;

    @Before
    public void setUp() {
        task = new Task(1L, "Task", "Content");
        taskDto = new TaskDto(1L, "TaskDto", "ContentDto");;
        taskList = new ArrayList<>();
    }

    @Test
    public void testMapToTask() {
        // Given

        // When
        Task task = taskMapper.mapToTask(taskDto);

        // Then
        Assert.assertEquals(ofNullable(1L).get(), task.getId());
        Assert.assertEquals("TaskDto", task.getTitle());
        Assert.assertEquals("ContentDto", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        // Given

        // When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        // Then
        Assert.assertEquals(ofNullable(1L).get(), taskDto.getId());
        Assert.assertEquals("Task", taskDto.getTitle());
        Assert.assertEquals("Content", taskDto.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        // Given
        taskList.add(task);

        // When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);

        // Then
        Assert.assertFalse(taskDtos.isEmpty());
        Assert.assertEquals(1, taskDtos.size());
    }
}
