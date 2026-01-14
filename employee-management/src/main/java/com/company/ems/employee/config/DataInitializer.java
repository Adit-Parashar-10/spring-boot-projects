package com.company.ems.employee.config;

import com.company.ems.employee.entity.Employee;
import com.company.ems.employee.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;

public class DataInitializer {

    private final EmployeeRepository employeeRepository;

    public DataInitializer(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void init(){
        Employee admin = new Employee();
        if(employeeRepository.count() == 0){
            admin.setName("super admin");
            admin.setEmail("admin@company.in");
            admin.setRole("Admin");
            employeeRepository.save(admin);
        }
    }
}
