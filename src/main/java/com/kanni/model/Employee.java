package com.kanni.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "Employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private int empId;

    private String empName;

    private double empSalary;

    private String phoneNumber;

}
