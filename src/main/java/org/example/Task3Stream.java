package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3Stream {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>(List.of(
                new Employee("Иванов Иван Иванович", 25, "Разработка", 80000.0),
                new Employee("Петрова Мария Сергеевна", 34, "Тестирование", 65000.0),
                new Employee("Сидоров Алексей Петрович", 28, "Разработка", 95000.0),
                new Employee("Козлова Анна Викторовна", 42, "HR", 55000.0),
                new Employee("Новиков Дмитрий Олегович", 31, "Аналитика", 75000.0)
        ));

        List<String> result = employees.stream()
                .map(e -> e.getFullName() + " - " + e.getDepartment())
                .collect(Collectors.toList());

        System.out.println("Результат:");
        result.forEach(System.out::println);
    }
}
