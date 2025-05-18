package org.example.app.entity;

import java.util.Map;

public class EmployeeMapper {
    public Employee mapData(Map<String, String> data) {
        Employee employee = new Employee();
        if (data.containsKey("id"))
            employee.setId(Integer.parseInt(data.get("id")));
        if (data.containsKey("name"))
            employee.setName(data.get("name"));
        if (data.containsKey("age"))
            employee.setAge(Integer.parseInt(data.get("age")));
        if (data.containsKey("position"))
            employee.setPosition(data.get("position"));
        if (data.containsKey("salary"))
            employee.setSalary(Float.parseFloat(data.get("salary")));
        return employee;
    }
}
