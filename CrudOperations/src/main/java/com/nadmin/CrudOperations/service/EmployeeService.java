package com.nadmin.CrudOperations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadmin.CrudOperations.bean.Employee;
import com.nadmin.CrudOperations.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepo;
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = new ArrayList<>();
		employeeRepo.findAll().forEach(employees::add);
		return employees;
	}
	public void addEmployee(Employee employee) 
	{
		employeeRepo.save(employee);
	}
	public void updateEmployee(String id,Employee employee) 
	{
		employeeRepo.save(employee);
	}
	public void deleteEmployee(String id) 
	{
		employeeRepo.deleteById(id);;
	}
	
}
