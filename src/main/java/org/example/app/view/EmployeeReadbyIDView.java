package org.example.app.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeReadbyIDView {

    public String getEmployeeId() {
        System.out.println("Enter employee ID: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }


    public void getOutput(String read) {
        System.out.println(read);
    }


}
