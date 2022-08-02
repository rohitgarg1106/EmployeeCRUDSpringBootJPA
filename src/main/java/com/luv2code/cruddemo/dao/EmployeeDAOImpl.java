package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        return entityManager.createQuery("from Employee").getResultList();

    }

    @Override
    public Employee findById(int id) {

        //get and return employee
        return entityManager.find(Employee.class, id);
    }


    @Override
    public void save(Employee employee) {

        entityManager.merge(employee);

    }
}
