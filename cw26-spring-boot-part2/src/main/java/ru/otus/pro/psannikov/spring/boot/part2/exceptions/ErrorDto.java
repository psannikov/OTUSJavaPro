package ru.otus.pro.psannikov.spring.boot.part2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class ErrorDto {
    private String code;
    private String message;
    private LocalDateTime dateTime;

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }
}
