package com.kanni.controller;

import com.kanni.model.Employee;
import com.kanni.model.Input;
import com.kanni.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sqlInjection")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping
    public List<Employee> getEmpDetails(@RequestBody Input input){
        return employeeService.findByEmpName(input.getEmpName());
    }

    @PostMapping("/jpa")
    public List<Employee> findByEmpDetails(@RequestBody Input input){
        return employeeService.findByEmpDetails(input.getEmpName());
    }

    @PostMapping("/jpa/native")
    public List<Employee> findByNativeEmpDetails(@RequestBody Input input){
        return employeeService.findByNativeEmpDetails(input.getEmpName());
    }

    @PostMapping("/native")
    public List<Employee> findByNativeEmployee(@RequestBody Input input){
        return employeeService.findByNativeEmployee(input.getEmpName());
    }
}
