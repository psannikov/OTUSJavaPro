package ru.otus.pro.psannikov.password.changer.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.password.changer.entities.TaskStatus;

public interface TaskStatusRepository extends ListCrudRepository<TaskStatus, Long> {
}
