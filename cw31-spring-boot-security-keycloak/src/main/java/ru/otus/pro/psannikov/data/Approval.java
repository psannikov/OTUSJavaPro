package ru.otus.pro.psannikov.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Approval(boolean approved) {}
