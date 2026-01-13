package com.company.ems.service.employee;

import com.company.ems.entity.Employee;
import com.company.ems.repository.EmployeeRepository;
import com.company.ems.service.EmployerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeServiceImplementation")
public class EmployeeServiceImplementation implements EmployerService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        throw new RuntimeException("Employee can't create an employee !!!");
    }

    @Override
    public List<Employee> getAllEmployee() {
        throw new RuntimeException("Employee can't see all the employee !!!");
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow( ()-> new RuntimeException("Entered wrong id !!!") );
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee exist = employeeRepository.findById(id).orElseThrow( ()-> new RuntimeException("Entered wrong id !!!") );

        exist.setName(employee.getName());

        return employeeRepository.save(exist);
    }

    @Override
    public void deleteEmployee(Long id) {
        throw new RuntimeException("Employee can't delete an employee !!!");
    }
}
