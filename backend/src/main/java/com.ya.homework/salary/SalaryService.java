package com.ya.homework.salary;

public interface SalaryService {

    Salary save(Salary salary);

    void update(Salary salary);

    void deleteAll();
}
