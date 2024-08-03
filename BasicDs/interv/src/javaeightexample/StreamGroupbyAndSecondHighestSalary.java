package javaeightexample;

import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupbyAndSecondHighestSalary {
    private static class Employee {
        private int id;
        private String name;
        private int salary;
        private String department;

        public Employee(int id, String name, int salary, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getSalary() { return salary; }
        public String getDepartment() { return department; }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 3000, "HR"),
                new Employee(2, "Bob", 2000, "HR"),
                new Employee(3, "Charlie", 4000, "HR"),
                new Employee(4, "David", 2500, "IT"),
                new Employee(5, "Eve", 3500, "IT"),
                new Employee(6, "Frank", 5000, "IT"),
                new Employee(7, "Grace", 4500, "Finance"),
                new Employee(8, "Hank", 5500, "Finance")
        );
        Map<String, Optional<Integer>> secondHighestSalaries = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.mapping(Employee::getSalary,
                        Collectors.toList()), salaries -> findSecondHighestSalary(salaries)
                )));
        secondHighestSalaries.forEach((department,salary)->
                System.out.println("Department: " + department + ", Second Highest Salary: " + salary.orElse(null)));

        //Collectors.collectingAndthen Example
        List<String> words = Arrays.asList("apple","banana","cherry");
        String result = words.stream().collect(Collectors.
                collectingAndThen(Collectors.joining(","), s->"Fruits: "+s));
        System.out.println(result);

        //MyFunctionInterface Example
        MyFunctionalInterface myFunctionalInterface = (s)-> System.out.println(s);
        myFunctionalInterface.myMethod("Hello World");
      //  System.out.println(null);

    }
    private static Optional<Integer> findSecondHighestSalary(List<Integer> salaries){
       return salaries.stream().distinct()
               .sorted(Comparator.reverseOrder()).skip(1).findFirst();
    }
}
