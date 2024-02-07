package ru.otus.pro.psannikov.spring.boot.security.https.dtos;

import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class ExerciseDtoRq {
    private LocalDate exerciseDate;
    private String subjectName;
    private String subjectDescription;
    private String costumerFirstName;
    private String costumerSecondName;
    private String teacherFirstName;
    private String teacherSecondName;
}
