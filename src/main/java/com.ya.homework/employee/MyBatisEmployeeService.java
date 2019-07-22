package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import com.ya.homework.salary.SalaryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MyBatisEmployeeService implements EmployeeService {

    private MyBatisEmployeeMapper employeeRepository;
    private SalaryService salaryService;

    public MyBatisEmployeeService(MyBatisEmployeeMapper employeeRepository, SalaryService salaryService) {
        this.employeeRepository = employeeRepository;
        this.salaryService = salaryService;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    public void deleteAllEmployees() {
       employeeRepository.deleteEmployees();
       salaryService.deleteAll();
    }

    @Override
    public void changeSalary(Long employeeId, Salary salary) {
        Employee employee = employeeRepository.getEmployeeById(employeeId);
        Salary salary1 = employee.getSalary();
        salary.setId(salary1.getId());
        salaryService.update(salary);
    }

    @Override
    public void createEmployee(Employee employee) {
        Salary saved = salaryService.save(employee.getSalary());
        employee.setSalary(saved);
        employeeRepository.createEmployee(employee);
    }
}
