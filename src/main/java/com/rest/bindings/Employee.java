package com.rest.bindings;


public class Employee {

	
		
		private Long id;
		
		private String employee_name;
		
		private float salary;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmployee_name() {
			return employee_name;
		}

		public void setEmployee_name(String employee_name) {
			this.employee_name = employee_name;
		}

		public float getSalary() {
			return salary;
		}

		public void setSalary(float salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", employee_name=" + employee_name + ", salary=" + salary + "]";
		}
		
		
		
}
