package com.ya.homework.salary;

import org.apache.ibatis.annotations.*;

@Mapper
public interface MyBatisSalaryMapper {

    @Select("SELECT * FROM salary WHERE id=#{id}")
    Salary getSalaryById(Long id);

    @Insert("INSERT INTO salary(summ) VALUES (#{summ})")
    @Options(useGeneratedKeys=true, keyProperty = "id", keyColumn = "id")
    int save(Salary salary);

    @Update("Update salary set summ=#{summ} where id=#{id}")
    int update(Salary salary);

    @Delete("DELETE FROM salary")
    int deleteAll();
}
