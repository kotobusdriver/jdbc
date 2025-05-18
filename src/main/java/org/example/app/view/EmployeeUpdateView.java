package org.example.app.view;

import org.example.app.entity.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeUpdateView {

    public String getEmployeeId() {

        System.out.println("\nUPDATE FORM (leave blank to keep current)");
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input employee id: ");
        return scanner.nextLine().trim();
    }

    public Map<String, String> getExistingData(Employee existingEmployee) {
        System.out.printf("Name [%s]: ", existingEmployee.getName());
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        String name = scanner.nextLine().trim();
        map.put("name", name.isEmpty() ? existingEmployee.getName() : name);

        System.out.printf("Age [%d]: ", existingEmployee.getAge());
        String age = scanner.nextLine().trim();
        map.put("age", age.isEmpty() ? String.valueOf(existingEmployee.getAge()) : age);

        System.out.printf("Position [%s]: ", existingEmployee.getPosition());
        String position = scanner.nextLine().trim();
        map.put("position", position.isEmpty() ? existingEmployee.getPosition() : position);

        System.out.printf("Salary [%.2f]: ", existingEmployee.getSalary());
        String salary = scanner.nextLine().trim();
        map.put("salary", salary.isEmpty() ? String.valueOf(existingEmployee.getSalary()) : salary);

        map.put("id", String.valueOf(existingEmployee.getId()));

        return map;
    }


    public void getOutput(String output) {
    System.out.println(output);
    }
}