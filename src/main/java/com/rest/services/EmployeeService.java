package com.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.bindings.Employee;

@Service
public interface EmployeeService 
{
	List<Employee> findAll();
	
	int insertEmployee(Employee employee); 
	
	int editEmployee(Employee employee); 

	int deleteEmployee(int id);

	Employee findById(int id);


}
