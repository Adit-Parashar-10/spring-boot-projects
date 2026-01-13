package com.company.ems.service;

import com.company.ems.entity.Employee;

import java.util.List;

public interface EmployerService {

    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getById(Long id);
    Employee updateEmployee(Long id,Employee employee);
    void deleteEmployee(Long id);
}

