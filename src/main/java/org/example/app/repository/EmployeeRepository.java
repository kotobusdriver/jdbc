package org.example.app.repository;

import org.example.app.config.DBConnect;
import org.example.app.entity.Employee;
import org.example.app.utils.UserMessage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRepository {

    private final static String TABLE_EMPLOYEES = "employees";

    public String create(Employee employee){
        String sql = "INSERT INTO " + TABLE_EMPLOYEES + " (name, age, position, salary) VALUES (?,?,?,?)";

        try (PreparedStatement pstmt = DBConnect.connect().prepareStatement(sql)){
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getAge());
            pstmt.setString(3, employee.getPosition());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.executeUpdate();
            return String.valueOf(UserMessage.DATA_INSERT_MSG);
            }
        catch (SQLException e) {
            return e.getMessage();
        }

    }

}
