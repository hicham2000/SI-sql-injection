package com.kanni;

import com.kanni.model.Employee;
import com.kanni.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.kanni.model"})
@EnableJpaRepositories(basePackages="com.kanni.repository")
public class SqlInjectionAttackDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlInjectionAttackDemoApplication.class, args);
	}


	@Autowired
	EmployeeRepository employeeRepository;

	@PostConstruct
	public void initEmpDetails(){

		List<Employee> employeeList=new ArrayList<>();
		employeeList.add(new Employee(1,"AAA",10000,"123455678"));
		employeeList.add(new Employee(2,"BBB",20000,"235677"));
		employeeList.add(new Employee(3,"CCC",30000,"7757456535"));
		employeeList.add(new Employee(4,"AAA",40000,"34467858"));
		employeeList.add(new Employee(5,"DDD",50000,"3575668"));
		employeeList.add(new Employee(6,"AAA",60000,"36758754"));

		employeeRepository.saveAll(employeeList);
	}

}
