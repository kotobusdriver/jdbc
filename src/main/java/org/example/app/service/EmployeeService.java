package org.example.app.service;

import org.example.app.entity.EmployeeMapper;
import org.example.app.exceptions.EmployeeException;
import org.example.app.repository.EmployeeRepository;

import java.util.Map;

public class EmployeeService {
    EmployeeRepository repository = new EmployeeRepository();

    public String create(Map<String, String> data) {
        Map<String, String> errors = new EmployeeValidator().validateEmployeeData(data);
        if (!errors.isEmpty()) {
            try {
                throw new EmployeeException("Check data", errors);
            } catch (EmployeeException e) {
                return e.getErrors(errors);
            }
        }
        return repository.create(new EmployeeMapper().mapData(data));
    }
}
