package com.ya.homework.employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll();

    void deleteAll();

    Employee getEmployeeById(Long employeeId);

    void save(Employee employee);
}
