package org.example.app.controller;

import org.example.app.entity.Employee;
import org.example.app.service.EmployeeService;
import org.example.app.utils.AppStarter;
import org.example.app.view.EmployeeCreateView;
import org.example.app.view.EmployeeReadView;
import org.example.app.view.EmployeeUpdateView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeController {

    EmployeeService service = new EmployeeService();

    public void create() {
        EmployeeCreateView view = new EmployeeCreateView();
        view.getOutput(service.create(view.getData()));
        AppStarter.startApp();
    }


    public void read() {
        EmployeeReadView view = new EmployeeReadView();
        view.getOutput(service.read());
        AppStarter.startApp();
    }


    public void update() {
        EmployeeUpdateView view = new EmployeeUpdateView();
        String employeeID = view.getEmployeeId();
        Employee existingEmployee = service.findById(Integer.parseInt(employeeID));
        Map<String, String> newEmployeeData = view.getExistingData(existingEmployee);
        view.getOutput(service.update(newEmployeeData));
        AppStarter.startApp();
    }

    public void delete() {
    }

    public void readById() {
    }
}
