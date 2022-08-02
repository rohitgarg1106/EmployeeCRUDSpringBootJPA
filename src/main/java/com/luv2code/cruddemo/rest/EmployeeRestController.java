package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.findEmployeeById(id);

        if(employee == null){
            throw new RuntimeException("Bad Request: Employee does not exists");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);

        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findEmployeeById(id);

        if(employee != null){
            employeeService.deleteEmployee(id);
            return "Employee Deleted Successfully";
        }
        else{
            return "Employee Does not exist";
        }

    }
}
