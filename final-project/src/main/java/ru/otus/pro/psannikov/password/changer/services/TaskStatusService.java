package ru.otus.pro.psannikov.password.changer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateResponsiblePersonDtoRq;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateTaskStatusDtoRq;
import ru.otus.pro.psannikov.password.changer.entities.ResponsiblePerson;
import ru.otus.pro.psannikov.password.changer.entities.TaskStatus;
import ru.otus.pro.psannikov.password.changer.repositories.TaskStatusRepository;

import java.util.List;
import java.util.Optional;
@Service
public class TaskStatusService {
    private final TaskStatusRepository taskStatusRepository;

    @Autowired
    public TaskStatusService(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    public Optional<TaskStatus> findById(Long id) {
        return taskStatusRepository.findById(id);
    }
    public List<TaskStatus> findAll() {
        return taskStatusRepository.findAll();
    }
    public void createNewTaskStatus(CreateOrUpdateTaskStatusDtoRq createOrUpdateTaskStatusDtoRq) {
        TaskStatus newTaskStatus = new TaskStatus(createOrUpdateTaskStatusDtoRq.getId(),
                createOrUpdateTaskStatusDtoRq.getDescription());
        taskStatusRepository.save(newTaskStatus);
    }
    public void updateTaskStatus(CreateOrUpdateTaskStatusDtoRq createOrUpdateTaskStatusDtoRq) {
        TaskStatus newTaskStatus = new TaskStatus(createOrUpdateTaskStatusDtoRq.getId(),
                createOrUpdateTaskStatusDtoRq.getDescription());
        taskStatusRepository.save(newTaskStatus);
    }
    public void deleteById (Long id) {
        taskStatusRepository.deleteById(id);
    }
}
