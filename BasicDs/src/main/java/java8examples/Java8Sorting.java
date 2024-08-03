package main.java.java8examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Sorting
{
    public static void main(String[] args) {
        Employee employee = new Employee("Anmit",100,8);
        Employee employee1 = new Employee("vivek",200,10);
        Employee employee2 = new Employee("jay",300,12);
        Employee employee3 = new Employee("shweata",400,16);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        List<Employee> collect = employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(collect);
    }
}
