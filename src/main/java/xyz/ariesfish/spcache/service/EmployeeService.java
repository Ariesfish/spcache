package xyz.ariesfish.spcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import xyz.ariesfish.spcache.bean.Employee;
import xyz.ariesfish.spcache.mapper.EmployeeMapper;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果缓存, 以后再要相同的结果直接从方法中获取, 不再调用方法
     * 设置key的值可以用SpEL: key = "#root.methodName+'['+#id+']'"
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"}, condition = "#id > 0", unless = "#result == null", key = "#id" /*, keyGenerator = "empKeyGenerator" */)
    public Employee getEmployee(Integer id) {
        System.out.println("Query No. " + id + " employee");
        return employeeMapper.getEmployeeById(id);
    }

    /**
     * 既调用方法, 又更新缓存
     * 更新后将方法的返回值也存放进缓存中, 但是默认
     * key: 传入的employee对象, value: 返回的employee对象
     * 这样就与查询的key不一致, 导致 key: 1 的缓存数据未更新
     * 添加 key = "#employee.id" 或 "#result.id"
     * 不过 @Cacheable 中不能用 "#result.id", 因为首先检查缓存数据时还未运行方法
     * @param employee
     * @return
     */
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmployee(Employee employee) {
        System.out.println("Update No. " + employee.getId() + " employee");
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * 缓存清除
     * allEntries = true: 指定清除缓存中所有数据
     * beforeInvocation = false: 缓存清除是否在方法调用之前执行, 默认在方法执行之后
     * @param id
     */
    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmployee(Integer id) {
        System.out.println("Delete No. " + id + " employee");
        // employeeMapper.deleteEmployeeById(id); 不实际删除数据库的数据
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#name")
            },
            put = { // 设置之后方法就一定会执行了
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            }
    )
    public Employee getEmployeeByName(String name) {
        return employeeMapper.getEmployeeByName(name);
    }
}
