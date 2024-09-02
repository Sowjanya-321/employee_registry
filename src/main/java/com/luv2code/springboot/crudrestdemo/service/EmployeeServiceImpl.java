package com.luv2code.springboot.crudrestdemo.service;

import com.luv2code.springboot.crudrestdemo.dao.EmployeeRepository;
import com.luv2code.springboot.crudrestdemo.entity.EmployeeEntity;
import com.luv2code.springboot.crudrestdemo.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }

    public List<Employee> findAll(){
       List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntityList) {
            Employee employee = new Employee();

            employee.setId(employeeEntity.getId());

            employee.setFirstName(employeeEntity.getFirstName());

            employee.setLastName(employeeEntity.getLastName());

           employee.setEmail(employeeEntity.getEmail());
           employeeList.add(employee);


       }
       return employeeList;
    }
    @Override
    public Employee findById(int theId) {
        EmployeeEntity employeeEntityRecord = employeeRepository.findById(theId).get();
        Employee employee = new Employee();

        employee.setId(employeeEntityRecord.getId());
        employee.setFirstName(employeeEntityRecord.getFirstName());
        employee.setLastName(employeeEntityRecord.getLastName());
        employee.setEmail(employeeEntityRecord.getEmail());
        return employee;
    }



    @Override
    public Employee save(Employee theEmployee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(theEmployee.getId());
        employeeEntity.setFirstName(theEmployee.getFirstName());
        employeeEntity.setLastName(theEmployee.getLastName());
        employeeEntity.setEmail(theEmployee.getEmail());
        EmployeeEntity employeeEntitysingleRecord = employeeRepository.save(employeeEntity);
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmail(employeeEntity.getEmail());
        return employee;


    }

    @Override
    public void deleteById(int theId) {
         employeeRepository.deleteById(theId);



    }
}
