package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PutMapping(value = "employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        service.createEmployee(employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("employees")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @PostMapping("employees/{employeeId}/salary")
    public ResponseEntity changeSalary(@PathVariable Long employeeId, @RequestBody Salary salary) {
        //validate employeeId
        service.changeSalary(employeeId, salary);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("employees")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity deleteEmployees() {
       service.deleteAllEmployees();
       return ResponseEntity.ok(HttpStatus.OK);
    }
}
