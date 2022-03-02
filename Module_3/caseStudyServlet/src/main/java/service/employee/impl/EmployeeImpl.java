package service.employee.impl;

import model.employee.Employee;
import repository.employee.impl.EmployeeRepo;
import service.employee.EmployeeService;

import java.util.List;

public class EmployeeImpl implements EmployeeService {
    EmployeeRepo employeeRepo = new EmployeeRepo();
    @Override
    public List<Employee> selectAll() {
        return employeeRepo.selectAll();
    }

    @Override
    public void create(Employee employee) {
        employeeRepo.create(employee);
    }

    @Override
    public void delete(int employee_id) {
        employeeRepo.delete(employee_id);
    }

    @Override
    public Employee selectEmployee(int employee_id) {
        return employeeRepo.selectEmployee(employee_id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepo.update(employee);
    }

    @Override
    public List<Employee> search(String employee_name) {
        return employeeRepo.search(employee_name);
    }
}
