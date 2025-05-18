package org.example.app.service;

import org.example.app.utils.UserMessage;

import java.util.HashMap;
import java.util.Map;

public class EmployeeValidator {

    public Map<String, String> validateEmployeeData(Map<String, String> data) {

        Map<String, String> errors = new HashMap<>();

        if(data.containsKey("id") && EmployeeValidator.isIdValid(data.get("id")))
            errors.put("id", String.valueOf(UserMessage.INCORRECT_VALUE_MSG));

        if (data.containsKey("name")) {
            if (data.get("name") != null & data.get("name").isEmpty())
                errors.put("name", String.valueOf(UserMessage.INPUT_REQ_MSG));
        }

        if(data.containsKey("age") && EmployeeValidator.isAgeValid(data.get("age")))
            errors.put("age", String.valueOf(UserMessage.INCORRECT_AGE_MSG));


        if (data.containsKey("position")) {
            if (data.get("position") != null & data.get("position").isEmpty())
                errors.put("position", String.valueOf(UserMessage.INPUT_REQ_MSG));
        }

        if(data.containsKey("salary") && EmployeeValidator.isSalaryValid(data.get("salary")))
            errors.put("salary", String.valueOf(UserMessage.INCORRECT_AGE_MSG));

        return errors;
    }

    private static boolean isSalaryValid(String salary) {
        if (salary == null || salary.trim().isEmpty())
            return false;

        try {
            double a = Double.parseDouble(salary.trim());
            return a >= 1 && a <= 1000000000;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isAgeValid(String age) {
        if (age == null || age.trim().isEmpty())
            return false;

        try {
            int a = Integer.parseInt(age.trim());
            return a >= 18 && a <= 100;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isIdValid(String id) {
        if (id != null) {
            return id.isEmpty() || !id.matches("^[1-9]$");
        }
        return false;
    }
}
