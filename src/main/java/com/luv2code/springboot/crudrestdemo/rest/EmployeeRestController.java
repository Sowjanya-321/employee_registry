package com.luv2code.springboot.crudrestdemo.rest;

import com.luv2code.springboot.crudrestdemo.dao.EmployeeRepository;
import com.luv2code.springboot.crudrestdemo.entity.EmployeeEntity;
import com.luv2code.springboot.crudrestdemo.model.Employee;
import com.luv2code.springboot.crudrestdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    // quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;

    }
    //expose "/employees" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        List<Employee> employeeEntityList = employeeService.findAll();
        return employeeEntityList;
    }

    @GetMapping("/getEmployee/{id}")
    public Employee findById(@PathVariable("id")  int theId){
        Employee employee = employeeService.findById(theId);
        return employee;
    }
    @PostMapping("/addEmployee")
    public Employee save(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/deleteEmployee/{theId}")
    public void deleteById(@PathVariable int theId){
       employeeService.deleteById(theId);

    }

    @PutMapping("/updateEmployee")
    public  Employee updateEmployee(@RequestBody Employee employee){
        Employee theEmployee = employeeService.save(employee);
        return theEmployee;
    }


}
