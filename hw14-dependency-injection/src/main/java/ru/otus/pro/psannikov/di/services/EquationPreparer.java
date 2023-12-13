package ru.otus.pro.psannikov.di.services;

import ru.otus.pro.psannikov.di.model.Equation;

import java.util.List;

public interface EquationPreparer {
    List<Equation> prepareEquationsFor(int base);
}
