package ru.otus.pro.psannikov.spring.data.jdbc.dtos;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrUpdateCategoryDtoRq {
    private Long id;
    private String title;
}
