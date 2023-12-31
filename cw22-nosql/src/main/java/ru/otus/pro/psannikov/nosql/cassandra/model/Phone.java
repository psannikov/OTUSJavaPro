package ru.otus.pro.psannikov.nosql.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Phone {
    private UUID id;
    private String model;
    private String color;
    private String serialNumber;
}
