package ru.otus.pro.psannikov.stream.stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PipelineDemo {

    public static void main(String... args) {
        List<Employee> employees = List.of(
                new Employee("John Smith", 20_000),
                new Employee("Susan Johnson", 42_000),
                new Employee("Erik Taylor", 55_000),
                new Employee("Zack Anderson", 14_000),
                new Employee("Sarah Lewis", 130_000));

        List<Employee> updatedSalaryEmployees =
                employees.stream()
                         .filter(employee -> {
                             System.out.println("Filtering employee " + employee.getName());
                             return employee.getSalary() < 80_000;
                         })
                         .sorted(Employee.SORT_BY_SALARY_ASC)
                         .map(employee -> {
                             System.out.println("Mapping employee " + employee.getName());
                             return new Employee(employee.getName(), (int)(employee.getSalary() * 1.05));
                         })
                         .collect(Collectors.toList());

        System.out.println(updatedSalaryEmployees);
    }

    @Getter
    @RequiredArgsConstructor
    private static final class Employee {

        public static final Comparator<Employee> SORT_BY_SALARY_ASC = Comparator.comparingInt(Employee::getSalary);

        private final String name;
        private final int salary;

        @Override
        public String toString() {
            return name + '-' + salary;
        }
    }
}
