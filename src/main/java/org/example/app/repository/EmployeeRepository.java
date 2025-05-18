package org.example.app.repository;

import org.example.app.config.DBConnect;
import org.example.app.entity.Employee;
import org.example.app.utils.UserMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<List<Employee>> read() {
        String sql = "SELECT * FROM " + TABLE_EMPLOYEES;
        List <Employee> list = new ArrayList<>();
        try (Statement stmt = DBConnect.connect().createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Employee (
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("position"),
                        rs.getFloat("salary")
                ));
            }
            return Optional.of(list);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String update(Employee employee) {
        if (readById(employee.getId()).isEmpty()){
            return String.valueOf(UserMessage.NO_DATA_MSG);
        }
        else {
            String sql = "UPDATE " + TABLE_EMPLOYEES + " SET name = ?, age = ?, position = ?, salary = ?" + " WHERE id = ?";

            try(PreparedStatement pstmt = DBConnect.connect().prepareStatement(sql)){
                pstmt.setString(1, employee.getName());
                pstmt.setInt(2, employee.getAge());
                pstmt.setString(3, employee.getPosition());
                pstmt.setFloat(4, employee.getSalary());
                pstmt.setInt(5, employee.getId());
                pstmt.executeUpdate();
                return String.valueOf(UserMessage.DATA_INSERT_MSG);
            }
            catch (SQLException e) {
                return e.getMessage();
            }
        }
    }


    public String delete(int id) {
        if (findById(id).isEmpty()){
            return String.valueOf(UserMessage.NO_DATA_MSG);
        }
        else{
            String sql = "DELETE FROM " + TABLE_EMPLOYEES + " WHERE id = ?";
            try (PreparedStatement prstm = DBConnect.connect().prepareStatement(sql)){
                prstm.setInt(1, id);
                prstm.executeUpdate();
                return String.valueOf(UserMessage.DATA_DELETED_MSG);
            }
            catch (SQLException e) {
                return e.getMessage();
            }
        }
    }

    private Optional<Employee> readById(int id) {
        String sql = "SELECT * FROM " + TABLE_EMPLOYEES + " WHERE id = ?";

        try(PreparedStatement pstmt = DBConnect.connect().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Employee employee = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("position"),
                    rs.getFloat("salary")
            );
            return Optional.of(employee);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Employee> findById(int id) {
        String sql = "SELECT * FROM " + TABLE_EMPLOYEES + " WHERE id = ?";
        try (PreparedStatement pstmt = DBConnect.connect().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("position"),
                            rs.getFloat("salary")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }



}
