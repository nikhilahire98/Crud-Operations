package com.nadmin.CrudOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadmin.CrudOperations.bean.Employee;
import com.nadmin.CrudOperations.service.EmployeeService;
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	@RequestMapping(method = RequestMethod.POST, value="/employees")
	public String addEmployee(@RequestBody Employee employee)
	{
		employeeService.addEmployee(employee);
		return "Employee record added successfully.\nid:" +employee.getId()+"\nname :" +employee.getName()+ "\nsalary :"+employee.getSalary();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/employees/{id}")
	public String updateEmployee(@PathVariable String id, @RequestBody Employee employee)
	{
		employeeService.updateEmployee(id, employee);
		return "Employee record updated successfully. \nid : "+employee.getId()+"\nname :"+employee.getName()+ "\nsalary :"+employee.getSalary();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	public String deleteEmployee(@PathVariable String id)
	{
		employeeService.deleteEmployee(id);
		return "Employee record deleted successfully.";
	}
}
