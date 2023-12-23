package ru.otus.pro.psannikov.lru.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CacheDto {
    private String cacheKey;
    private String cacheValue;

}