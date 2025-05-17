package org.example.app.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeCreateView {
    public Map<String, String> getData() {
        System.out.println("\nCREATE FORM");
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input name in format first name, last name: ");
        map.put("name", scanner.nextLine().trim());
        System.out.print("Input age in years: ");
        map.put("age", scanner.nextLine().trim());
        System.out.print("Input position : ");
        map.put("position", scanner.nextLine().trim());
        System.out.print("Input salary: ");
        map.put("salary", scanner.nextLine().trim());
        return map;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
