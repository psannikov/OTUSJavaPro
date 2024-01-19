package ru.otus.pro.psannikov.spring.boot.security.https.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Approval(boolean approved) {}
