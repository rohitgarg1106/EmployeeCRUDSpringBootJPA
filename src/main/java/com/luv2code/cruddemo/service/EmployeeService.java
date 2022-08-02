package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findEmployeeById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}
