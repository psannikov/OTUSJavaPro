package ru.otus.pro.psannikov.spring.boot.security.https.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.spring.boot.security.https.dtos.ExerciseDtoRq;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Exercise;

import java.util.List;

public interface ExercisesRepository extends ListCrudRepository<Exercise, Long> {
    @Query("select exercise_date, subject_name, subject_description, " +
            "costumer_first_name, costumer_second_name, teacher_first_name, teacher_second_name " +
            "from v_exercises where subject_id = :id")
    List<ExerciseDtoRq> findAllBySubjectId(Long id);
    @Query("select exercise_date, subject_name, subject_description, " +
            "costumer_first_name, costumer_second_name, teacher_first_name, teacher_second_name " +
            "from v_exercises where costumer_id = :id")
    List<ExerciseDtoRq> findAllByCostumerId(Long id);
    @Query("select exercise_date, subject_name, subject_description, " +
            "costumer_first_name, costumer_second_name, teacher_first_name, teacher_second_name " +
            "from v_exercises where teacher_id = :id")
    List<ExerciseDtoRq> findAllByTeacherId(Long id);
}
