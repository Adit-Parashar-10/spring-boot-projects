package com.company.ems.config;

import com.company.ems.entity.Employee;
import com.company.ems.repository.EmployeeRepository;
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
