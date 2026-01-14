package com.company.ems.employee.service;

import com.company.ems.employee.entity.Employee;

import java.util.List;

public interface EmployerService {

    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getById(Long id);
    Employee updateEmployee(Long id,Employee employee);
    void deleteEmployee(Long id);
}

