package com.luv2code.springboot.crudrestdemo.service;

import com.luv2code.springboot.crudrestdemo.entity.EmployeeEntity;
import com.luv2code.springboot.crudrestdemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
