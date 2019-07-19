package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    public Long id;
    public String name;
    public Salary salary;
}
