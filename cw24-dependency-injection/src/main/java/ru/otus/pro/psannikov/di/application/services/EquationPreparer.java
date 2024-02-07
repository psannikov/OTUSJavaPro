package ru.otus.pro.psannikov.di.application.services;

import ru.otus.pro.psannikov.di.application.model.Equation;

import java.util.List;

public interface EquationPreparer {
    List<Equation> prepareEquationsFor(int base);
}
