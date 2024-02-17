package ru.otus.pro.psannikov.configuration.db.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.configuration.db.entities.TaskStatus;

public interface TaskStatusRepository extends ListCrudRepository<TaskStatus, Long> {
}
