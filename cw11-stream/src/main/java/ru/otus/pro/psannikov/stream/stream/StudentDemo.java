package ru.otus.pro.psannikov.stream.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDemo {


    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Alex", 22, 5, 4.5),
                                         new Student("Maria", 22, 5, 3.5),
                                         new Student("John", 12, 4, 4.7),
                                         new Student("Bob", 22, 5, 4.8));

        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAvgMark() > 4 && student.getCourse() == 5) {
                result.add(student);
            }
        }
        result.sort((o1, o2) -> Double.compare(o2.getAvgMark(), o1.getAvgMark()));

        for (Student student : result) {
            System.out.println(student.getName());
        }

        List<Student> resultNew = students.stream()
                                          .filter(student -> student.getAvgMark() > 4)
                                          .filter(student -> student.getCourse() == 5)
                                          .sorted(Comparator.comparingDouble(Student::getAvgMark).reversed())
                                          .collect(Collectors.toList());

        resultNew.forEach(student -> System.out.println(student.getName()));

        for (Student student : resultNew) {
            System.out.println(student);
        }

        List<Student> resultNew2 = new ArrayList<>();
        students.stream()
                .filter(student -> student.getAvgMark() > 4)
                .filter(student -> student.getCourse() == 5)
                .sorted(Comparator.comparingDouble(Student::getAvgMark).reversed())
                .forEach(resultNew2::add);

        resultNew2.forEach(student -> System.out.println(student.getName()));
    }
}
