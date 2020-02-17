package xyz.ariesfish.spcache.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import xyz.ariesfish.spcache.bean.Employee;

@Repository
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id=#{id}")
    @Results(id = "map", value={
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "lastName", property = "lastName"),
            @Result(column = "email", property = "email"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "d_id", property = "departmentId")
    })
    Employee getEmployeeById(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{departmentId} WHERE id=#{id}")
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    void deleteEmployeeById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{departmentId})")
    void insertEmployee(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName=#{name}")
    @ResultMap("map")
    Employee getEmployeeByName(String name);
}
