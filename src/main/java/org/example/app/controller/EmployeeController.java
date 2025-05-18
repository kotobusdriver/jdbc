package org.example.app.controller;

import org.example.app.service.EmployeeService;
import org.example.app.utils.AppStarter;
import org.example.app.view.EmployeeCreateView;
import org.example.app.view.EmployeeReadView;

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
    }

    public void delete() {
    }

    public void readById() {
    }
}
