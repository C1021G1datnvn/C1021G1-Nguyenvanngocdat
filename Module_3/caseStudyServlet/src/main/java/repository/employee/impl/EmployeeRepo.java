package repository.employee.impl;

import model.employee.Employee;
import repository.DBConnection;
import repository.employee.IEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployee {
    DBConnection dbConnection = new DBConnection();
    @Override
    public List<Employee> selectAll() {
        Connection connection = dbConnection.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(" select * from employee join position on position.position_id = employee.position_id join education_degree on education_degree.education_degree_id = employee.education_degree_id join division on division.division_id = employee.division_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                Double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String position_name = resultSet.getString("position_name");
                String education_degree_name = resultSet.getString("education_degree_name");
                String division_name = resultSet.getString("division_name");
                Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone
                , employee_email, employee_address, position_id, education_degree_id, division_id, position_name, education_degree_name, division_name);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary,employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id) values (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int employee_id) {
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from employee where employee_id = ?");
            preparedStatement.setInt(1, employee_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee selectEmployee(int employee_id) {
        Connection connection = dbConnection.getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id from employee where employee_id = ?");
            preparedStatement.setInt(1, employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ? where employee_id = ?;");
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.setInt(11, employee.getEmployee_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> search(String employee_name) {
        Connection connection = dbConnection.getConnection();
        List<Employee> employeeList = new ArrayList<>();

        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee join position on position.position_id = employee.position_id join education_degree on education_degree.education_degree_id = employee.education_degree_id join division on division.division_id = employee.division_id where employee_name like  ?;");
            preparedStatement.setString(1, "%"+employee_name+"%");
            resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployee_id(resultSet.getInt("employee_id"));
                employee.setEmployee_name(resultSet.getString("employee_name"));
                employee.setEmployee_birthday(resultSet.getString("employee_birthday"));
                employee.setEmployee_id_card(resultSet.getString("employee_id_card"));
                employee.setEmployee_salary(resultSet.getDouble("employee_salary"));
                employee.setEmployee_phone(resultSet.getString("employee_phone"));
                employee.setEmployee_email(resultSet.getString("employee_email"));
                employee.setEmployee_address(resultSet.getString("employee_address"));
                employee.setPosition_id(resultSet.getInt("position_id"));
                employee.setEducation_degree_id(resultSet.getInt("education_degree_id"));
                employee.setDivision_id(resultSet.getInt("division_id"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
