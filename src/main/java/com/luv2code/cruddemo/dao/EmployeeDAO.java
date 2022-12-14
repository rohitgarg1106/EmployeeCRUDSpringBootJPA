package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    void save(Employee employee);
}
