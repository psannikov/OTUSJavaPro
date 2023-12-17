package ru.otus.pro.psannikov.spring.boot.security.https.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDtoRq {
    private LocalDate exerciseDate;
    private String subjectName;
    private String subjectDescription;
    private String costumerFirstName;
    private String costumerSecondName;
    private String teacherFirstName;
    private String teacherSecondName;

}
