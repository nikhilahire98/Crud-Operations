package com.nadmin.CrudOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadmin.CrudOperations.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
