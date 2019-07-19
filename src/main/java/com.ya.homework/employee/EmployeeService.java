package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.getAll();
    }

    public void deleteAllEmployees() {
       employeeRepository.deleteAll();
    }

    public void changeSalary(Long employeeId, Salary salary) {
        Employee employee = employeeRepository.getEmployeeById(employeeId);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
