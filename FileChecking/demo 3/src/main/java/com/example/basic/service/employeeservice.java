package com.example.basic.service;

import com.example.basic.entity.Employee;
import com.example.basic.entity.User;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;

import java.util.List;

public interface employeeservice {
    List<Employee> getAllemployees();

    Employee saveStudent(Employee employee);

    /*User register(User user);*/

    Employee getEmployeebyId(Long id);

    Employee updateEmployee(Employee employee);

    void DeleteEmployee(Long id);

    public List<Employee> getByKeyword(String keyword);





}
