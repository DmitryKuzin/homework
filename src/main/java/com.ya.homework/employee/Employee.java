package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee {

    public Long id;

    @NotBlank
    public String name;
    @Valid
    public Salary salary;
}
