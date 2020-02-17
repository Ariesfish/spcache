package xyz.ariesfish.spcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.ariesfish.spcache.bean.Employee;
import xyz.ariesfish.spcache.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employee")
    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/delemp")
    public String deleteEmployee(Integer id) {
        employeeService.deleteEmployee(id);
        return "success";
    }

    @GetMapping("/employee/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name) {
        return employeeService.getEmployeeByName(name);
    }
}
