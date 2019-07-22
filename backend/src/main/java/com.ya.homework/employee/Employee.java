package com.ya.homework.employee;

import com.ya.homework.salary.Salary;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;

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
