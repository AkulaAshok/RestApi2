package com.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.rest.bindings.Employee;
import com.rest.services.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/")
	public String home(Model model) {
		List<Employee> employees = employeeService.findAll();

		int status=0;
		if(employees==null)
		{
			model.addAttribute("not found",status);
			return "index";
		}
		System.out.println(employees);

		model.addAttribute("employees", employees);
		return "index";
	}
	@GetMapping("/addemployee")
	public String addEmployeeForm() {
		return "addemployee";
	}

	@PostMapping("/employee")
	public String addEmployee(Employee employee, Model model) 
	{
		String msg = "";

		int status = 0;

		System.out.println(employee);
		
		int result=employeeService.insertEmployee(employee);
		
		System.out.println(result);

		if (result>=200 && result<=299) {
			// Employee was added successfully
			msg = "Added successfully";
			status = 1;
		} else 
		{
			// Employee was not added
			msg = "Addition failed";
			status = 0;
		}

		model.addAttribute("message", msg);
		model.addAttribute("status", status);

		return "redirect:/";
	}
	
	@PostMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") int id,Model model)
	{
		String msg="";
		
		int status=0;
		
		int value=employeeService.deleteEmployee(id);
		
		if(value>=200 && value<=299)
		{
			msg = "Deleted successfully";
			status = 1;
			
		}
		
		else
		{
			msg = "Deletion unsuccessfull";
			status = 2;
			
		}
		
		System.out.println(msg);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		return "redirect:/";
	}
	
	
	@GetMapping("/employeeUpdateForm/{id}")
	public String updateForm(@PathVariable("id") int id,Model model)
	{
		
		String msg="s";
		
		Employee employee=employeeService.findById(id);
		
		System.out.println("e"+employee);
		if(employee==null)
		{
			model.addAttribute("id not found",msg);
			
			return "error";
			
		}
		
		model.addAttribute(employee);
		return "update";
		
	}

	
	
	@PostMapping("/employeeUpdate")
	public String editEmployee(Employee employee, Model model) 
	{
		String msg = "";

		int status = 0;

		// System.out.println(employee);
		
		int result=employeeService.editEmployee(employee);
		
		System.out.println(result);

		if (result==1)
		{
			msg = "updated successfully";
			
			status = 1;
		} else 
		{
			// Employee was not added
			msg = "updation failed";
			status = 0;
		}

		model.addAttribute("message", msg);
		model.addAttribute("status", status);

		return "redirect:/";
	}
	

}
