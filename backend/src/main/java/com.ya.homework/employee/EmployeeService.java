package com.ya.homework.employee;

import com.ya.homework.salary.Salary;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    void deleteAllEmployees();

    void changeSalary(Long employeeId, Salary salary);

    void createEmployee(Employee employee);
}
