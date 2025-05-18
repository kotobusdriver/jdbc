package org.example.app.controller;

import org.example.app.service.EmployeeService;
import org.example.app.utils.AppStarter;
import org.example.app.view.EmployeeCreateView;

public class EmployeeController {

    EmployeeService service = new EmployeeService();

    public void create() {
        EmployeeCreateView view = new EmployeeCreateView();
        view.getOutput(service.create(view.getData()));
        AppStarter.startApp();
    }


    public void read() {
    }


    public void update() {
    }

    public void delete() {
    }

    public void readById() {
    }
}
