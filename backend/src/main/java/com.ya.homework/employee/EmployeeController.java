package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("employee")
@Validated
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody @Valid Employee employee) {
        service.createEmployee(employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("all")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @PutMapping("{employeeId}/salary")
    public ResponseEntity changeSalary(@PathVariable @Min(0) Long employeeId, @RequestBody @Valid Salary salary) {
        service.changeSalary(employeeId, salary);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("all")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity deleteEmployees() {
       service.deleteAllEmployees();
       return ResponseEntity.ok(HttpStatus.OK);
    }
}
