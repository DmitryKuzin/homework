package com.ya.homework;

import com.ya.homework.salary.MyBatisSalaryMapper;
import com.ya.homework.salary.Salary;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.Assert.*;

@Slf4j
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MyBatisSalaryMapperTest {

    @Autowired
    private MyBatisSalaryMapper salaryMapper;

    @Test
    public void testGetSalaryById() {
        Salary salary = Salary.builder().summ(200L).build();
        salaryMapper.save(salary);
        Salary salaryById = salaryMapper.getSalaryById(salary.getId());

        assertNotNull("test getSalaryById failed - salary must not be null", salaryById);
        assertEquals("test getSalaryById failed - salary id must not be different",
                salary.getId(), salaryById.getId());
    }

    @Test
    public void testSaveSalary() {
        Salary salary = Salary.builder().summ(200L).build();
        int count = salaryMapper.save(salary);
        assertEquals("test testSaveSalary failed - insert count must be equal to 1", 1, count);
        assertNotNull("test testSaveSalary failed - salary id must not be null", salary.getId());
        assertTrue("test createEmployee failed - employee id must be greater than 0",
                salary.getId() > 0);
    }

    @Test
    public void testDeleteAll() {
        Salary salary = Salary.builder().summ(200L).build();
        int count = salaryMapper.save(salary);
        assertEquals("test deleteAll - insert count must be equal to 1", 1, count);

        count = salaryMapper.deleteAll();
        assertTrue("test deleteAll - delete count must be equal to 1", count > 0);

        Salary deletedSalary = salaryMapper.getSalaryById(salary.getId());
        assertNull("test delete by primary key - deleted customer must be null", deletedSalary);
    }

    @Test
    public void testUpdateSalary() {
        Salary salary = Salary.builder().summ(200L).build();
        salaryMapper.save(salary);

        salary.setSumm(300L);

        int count = salaryMapper.update(salary);
        assertEquals("test updateSalary failed - update count must be equal to 1", 1, count);

        salary = salaryMapper.getSalaryById(salary.getId());
        assertEquals("test updateSalary failed - summ field not updated", Long.valueOf(300L), salary.getSumm());
    }

}
