package org.example.app.service;

import org.example.app.controller.EmployeeController;
import org.example.app.exceptions.OptionException;
import org.example.app.utils.AppStarter;
import org.example.app.utils.UserMessage;
import org.example.app.view.AppView;

public class AppService {

    EmployeeController employeeController = new EmployeeController();

    public void handleOption(int option) {
        switch (option) {
            case 1 -> employeeController.create();
            case 2 -> employeeController.read();
            case 3 -> employeeController.update();
            case 4 -> employeeController.delete();
            case 5 -> employeeController.readById();
            case 0 -> new AppView().getOutput(Integer.toString(option));
            default -> {
                try {
                    throw new OptionException(UserMessage.INCORRECT_OPTION_MSG);
                } catch (OptionException e) {
                    new AppView().getOutput(e.getMessage());
                    AppStarter.startApp();
                }
            }
        }
    }

}
