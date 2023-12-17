package ru.otus.pro.psannikov.spring.boot.security.https.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("EXERCISES")
public class Exercise {
    @Id
    private Long id;
    private LocalDate exerciseDate;
    @MappedCollection(idColumn = "ID")
    private Subject subject;
    @MappedCollection(idColumn = "ID")
    private Costumer costumer;
    @MappedCollection(idColumn = "ID")
    private Teacher teacher;

    @PersistenceCreator
    public Exercise(Long id, LocalDate exerciseDate, Subject subject, Costumer costumer, Teacher teacher) {
        this.id = id;
        this.exerciseDate = exerciseDate;
        this.subject = subject;
        this.costumer = costumer;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(LocalDate exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
