package javaeightexample;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    int salary;

    Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + "(" + department + ", " + salary + ")";
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John Doe", "HR", 5000),
                new Employee("Jane Smith", "IT", 6000),
                new Employee("Sam Brown", "HR", 7000),
                new Employee("Lucy Green", "IT", 8000),
                new Employee("Mike White", "Sales", 4500)
        );
        Map<String,List<Employee>> employeeByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeeByDept);

        Map<Boolean,List<Employee>> emploueeBySalary = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.salary>5000));
        System.out.println(emploueeBySalary);
    }
}