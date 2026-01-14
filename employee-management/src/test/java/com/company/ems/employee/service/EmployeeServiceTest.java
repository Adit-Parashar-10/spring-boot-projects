package com.company.ems.employee.service;

import com.company.ems.employee.entity.Employee;
import com.company.ems.employee.service.employee.EmployeeServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeServiceImplementation employeeServiceImplementation;

    @Test
    void getEmployeeFromEmployee(){
        System.out.println("first unit test");
        Employee emp = employeeServiceImplementation.getById(5L);
        assertEquals(5L,emp.getId());
    }

}
