package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

    private Map<Long, Employee> employeeData;

    @PostConstruct
    private void init() {
        employeeData = new HashMap<>();
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Simon");
        employee.setSalary(Salary.builder().id(1L).summ(185000L).build());
        employeeData.put(employee.getId(), employee);
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(employeeData.values());
    }

    @Override
    public void deleteAll() {
        employeeData = new HashMap<>();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeData.get(employeeId);
    }

    @Override
    public void save(Employee employee) {
        employeeData.put(employee.getId(), employee);
    }
}
