package xyz.ariesfish.spcache;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ariesfish.spcache.bean.Employee;
import xyz.ariesfish.spcache.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpCacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

}
