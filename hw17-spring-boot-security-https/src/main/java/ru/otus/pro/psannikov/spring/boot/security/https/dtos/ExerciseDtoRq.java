package ru.otus.pro.psannikov.spring.boot.security.https.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
public class ExerciseDtoRq {
    private LocalDate exerciseDate;
    private String subjectName;
    private String subjectDescription;
    private String costumerFirstName;
    private String costumerSecondName;
    private String teacherFirstName;
    private String teacherSecondName;

    public ExerciseDtoRq() {
    }

    public LocalDate getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(LocalDate exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public String getCostumerFirstName() {
        return costumerFirstName;
    }

    public void setCostumerFirstName(String costumerFirstName) {
        this.costumerFirstName = costumerFirstName;
    }

    public String getCostumerSecondName() {
        return costumerSecondName;
    }

    public void setCostumerSecondName(String costumerSecondName) {
        this.costumerSecondName = costumerSecondName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherSecondName() {
        return teacherSecondName;
    }

    public void setTeacherSecondName(String teacherSecondName) {
        this.teacherSecondName = teacherSecondName;
    }
}
