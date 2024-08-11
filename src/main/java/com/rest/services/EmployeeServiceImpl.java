package com.rest.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.bindings.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
    private final String baseUrl = "http://localhost:8079/";


    RestTemplate restTemplate=new RestTemplate();
    
	@Override
	public List<Employee> findAll() 
	{
		 // Making the GET request and get the ResponseEntity
	    ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity(baseUrl + "/employee", Employee[].class);
	    
	    // Extract the body from the ResponseEntity
	    Employee[] employeesArray = responseEntity.getBody();
	    	
	    List<Employee> employees=Arrays.asList(employeesArray);
	    
	    
	    
	    return employees;
	}

	

	@Override
	public int insertEmployee(Employee employee) 
	{
	
		ResponseEntity<String> rt=restTemplate.postForEntity(baseUrl+"/employee", employee,String.class);
		
		String result=rt.getBody(); //ms
		
		HttpStatus statusCode=(HttpStatus) rt.getStatusCode();
		
		//System.out.println(statusCode); //201 created
		
		Integer value=statusCode.value(); //201
		
		//System.out.println(value); // 201
		
		//System.out.println(result); //added succesfully
	
		return value;
	}



	@Override
	public int deleteEmployee(int id) 
	{
		ResponseEntity<String> rt=restTemplate.exchange(baseUrl+"employee/{id}",HttpMethod.DELETE,null,String.class,id);
		
		HttpStatusCode statusCode=rt.getStatusCode();
		
		Integer value=statusCode.value();
		
		return value;
	}



	@Override
	public int editEmployee(Employee employee) 
	{
		ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/employee",HttpMethod.PUT,new HttpEntity<>(employee),String.class);
		
		HttpStatusCode status=response.getStatusCode();
		
		if(status.value()>=200 && status.value()<=299)
		{
			return 1;
		}
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Employee findById(int id) 
	{
		Employee employee = restTemplate.getForObject(baseUrl + "/employee/{id}", Employee.class, id);
		
	System.out.println(employee.getId());
		
		return employee;
	}
}
