package ru.otus.pro.psannikov.password.changer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateTaskStatusDtoRq;
import ru.otus.pro.psannikov.password.changer.entities.TaskStatus;
import ru.otus.pro.psannikov.password.changer.services.TaskStatusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task_status")
public class TaskStatusController {
    private final TaskStatusService taskStatusService;

    @Autowired
    public TaskStatusController(TaskStatusService taskStatusService) {
        this.taskStatusService = taskStatusService;
    }

    @GetMapping("/{id}")
    public Optional<TaskStatus> findById(@PathVariable Long id) {
        return taskStatusService.findById(id);
    }

    @GetMapping
    public List<TaskStatus> findAll() {
        return taskStatusService.findAll();
    }

    @PostMapping
    public void createNewTaskStatus(@RequestBody CreateOrUpdateTaskStatusDtoRq createOrUpdateTaskStatusDtoRq) {
        taskStatusService.createNewTaskStatus(createOrUpdateTaskStatusDtoRq);
    }

    @PutMapping
    public void updateTaskStatus(@RequestBody CreateOrUpdateTaskStatusDtoRq createOrUpdateTaskStatusDtoRq) {
        taskStatusService.updateTaskStatus(createOrUpdateTaskStatusDtoRq);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskStatusService.deleteById(id);
    }
}
