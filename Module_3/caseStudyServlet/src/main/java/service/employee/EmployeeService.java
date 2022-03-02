package service.employee;

import model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> selectAll();
    void create(Employee employee);
    void delete(int employee_id);
    Employee selectEmployee(int employee_id);
    void update(Employee employee);
    List<Employee> search(String employee_name);
}
