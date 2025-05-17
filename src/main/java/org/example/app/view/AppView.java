package org.example.app.view;

import org.example.app.utils.AppStarter;
import org.example.app.utils.UserMessage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {

    public int getOption (){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        getMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(UserMessage.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void getMenu() {
        System.out.print("""                
                
                OPTIONS:
                1 - Create an employee.
                2 - Read employee details.
                3 - Update employee details.
                4 - Delete employee details.
                5 - Read employee details by employee id.
                0 - Close the App.
                """);
        System.out.print("Input your option: ");
    }

    public void getOutput(String output) {
        if (output.equals("0")) {
            System.out.println(UserMessage.APP_CLOSE_MSG);
            System.exit(0);
        } else System.out.println(output);
    }
}