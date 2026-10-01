package org.example;

/*
    1. Необходимо обработать список с использованием Stream API.
    Задание состоит из нескольких этапов.   1.  Необходимо  реализовать java-класс сотрудник (код “Employee”).
    Приватные  поля  класса: ФИО (“fullName”   тип “String”), Возраст (“age”
    тип  “Integer”),  Отдел  (“department”  тип  “String”),  З/П  (“salary”  тип
    “Double”).  Класс  должен  содержать  геттеры  и  сеттеры  для  доступа  к
    полям.
    2. Необходимо  реализовать  предзаполненный  список  (тип
    “ArrayList<Employee>”) с объектами класса “Employee”, по которым будем
    выполняться задание. Необходимо создать не менее 5 элементов списка.
    3. Отсортировать список сотрудников по возрастанию зарплаты
    Выходные  данные:  в  консоль  напечатан  результат  выполнения  задания.
Объекты должны быть напечатаны в читаемом виде.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иванов Иван Васильевич", 35, "Здоровья", 55000.0));
        employees.add(new Employee("Чижов Петр Вадимович", 47, "Борьбы", 90000.0));
        employees.add(new Employee("Алохов Никита Васильевич", 19, "Борьбы", 90000.0));
        employees.add(new Employee("Петровна Анна Сергеевна", 27, "Видеоблогинга", 65000.0));
        employees.add(new Employee("Наумавна Алиса Юрьевна", 28, "Спорта", 54000.0));

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
        System.out.println("Сотрудник по возрастанию зарплаты");
        sorted.forEach(System.out::println);
    }

    private String fullName;

    private Integer age;

    private String department;
    private Double salary;

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ФИО='" + fullName + '\'' +
                ", Возраст=" + age +
                ", Отдел='" + department + '\'' +
                ", Зарплата=" + salary + " руб";
    }
}
