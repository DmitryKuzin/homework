package com.ya.homework.employee;


import com.ya.homework.salary.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyBatisEmployeeMapper {

    @Select("SELECT * FROM employee")
    @Results(value = {
            @Result(property = "salary", javaType = Salary.class,
                    column = "ref_salary",
                    one=@One(select = "com.ya.homework.salary.MyBatisSalaryMapper.getSalaryById"))
    })
    List<Employee> getEmployees();

    @Delete("DELETE FROM employee")
    int deleteEmployees();

    @Insert("INSERT INTO employee(name, ref_salary) VALUES (#{name}, #{salary.id})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn = "id")
    int createEmployee(Employee employee);

    @Select("SELECT * FROM employee WHERE id = #{employeeId}")
    @Results(value = {
            @Result(property = "salary", javaType = Salary.class,
                    column = "ref_salary",
                    one=@One(select = "com.ya.homework.salary.MyBatisSalaryMapper.getSalaryById"))
    })
    Employee getEmployeeById(Long employeeId);
}
