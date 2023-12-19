package ru.otus.pro.psannikov.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApprovalDtoRq {
    private Long subjectId;
    private Long costumerId;
    private Long teacherId;
}
