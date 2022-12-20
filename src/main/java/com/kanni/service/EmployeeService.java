package com.kanni.service;

import com.kanni.model.Employee;
import com.kanni.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public List<Employee> findByEmpName(String empName){

        return employeeRepository.findByEmpName(empName);
    }

    public List<Employee> findByEmpDetails(String empName){

        return employeeRepository.findAllEmployeeByEmpName(empName);
    }

    public List<Employee> findByNativeEmpDetails(String empName){

        return employeeRepository.findAllEmployeeByEmpNameNative(empName);
    }

    public List<Employee> findByNativeEmployee(String empName){

        // sql injection attack
      //  Query query=entityManager.createNativeQuery("SELECT * FROM EMPLOYEE WHERE EMP_NAME ='"+empName+"'",Employee.class);

        Query query=entityManager.createNativeQuery("SELECT * FROM EMPLOYEE WHERE EMP_NAME = :empName ",Employee.class);
        query.setParameter("empName", empName);

        return query.getResultList();
    }




}
