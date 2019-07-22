package com.ya.homework;

import com.ya.homework.salary.MyBatisSalaryMapper;
import com.ya.homework.salary.MyBatisSalaryService;
import com.ya.homework.salary.Salary;
import com.ya.homework.salary.SalaryService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class SalaryServiceTest {

    private SalaryService salaryService;

    private Salary salary;

    @Before
    public void setUp() {
        salary = Salary.builder().id(1L).summ(100L).build();


        MyBatisSalaryMapper salaryMapper = Mockito.mock(MyBatisSalaryMapper.class);
        Mockito.when(salaryMapper.save(salary))
                .thenReturn(1);
        salaryService = new MyBatisSalaryService(salaryMapper);

    }

    @Test
    public void testSave() {
        Salary returned = salaryService.save(salary);
        assertEquals("test save failed - returned object must be equal to initial object", returned, salary);
    }

}
