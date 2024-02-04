package ru.otus.pro.psannikov.reactive.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDto {
    private Long id;
    private String description;
}
