package com.luv2code.springboot.crudrestdemo.dao;

import com.luv2code.springboot.crudrestdemo.entity.EmployeeEntity;
import com.luv2code.springboot.crudrestdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

}
