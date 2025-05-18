package org.example.app.service;

import org.example.app.entity.Employee;
import org.example.app.entity.EmployeeMapper;
import org.example.app.exceptions.EmployeeException;
import org.example.app.repository.EmployeeRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import org.example.app.utils.UserMessage;

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

    public String read() {
        Optional<List<Employee>> output = repository.read();
        if (output.isPresent()) {
            List<Employee> list = output.get();
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder sb = new StringBuilder();
                list.forEach(employee ->
                        sb.append(count.incrementAndGet()).
                                append(") ").
                                append(employee.toString()).
                                append("\n"));
                return sb.toString();
            }
            else return String.valueOf(UserMessage.NO_DATA_MSG);
        }
        else return String.valueOf(UserMessage.NO_DATA_MSG);
    }
}
