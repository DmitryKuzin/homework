package com.ya.homework.salary;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyBatisSalaryService implements SalaryService {

    private MyBatisSalaryMapper salaryRepository;

    public MyBatisSalaryService(MyBatisSalaryMapper salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Salary save(Salary salary) {
        salaryRepository.save(salary);
        return salary;
    }

    @Override
    public void update(Salary salary) {
        salaryRepository.update(salary);
    }

    @Override
    public void deleteAll() {
        salaryRepository.deleteAll();
    }

}
