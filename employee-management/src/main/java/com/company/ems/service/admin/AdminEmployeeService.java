package com.company.ems.service.admin;

import com.company.ems.entity.Employee;
import com.company.ems.repository.EmployeeRepository;
import com.company.ems.service.EmployerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminEmployeeService")
public class AdminEmployeeService implements EmployerService {

    private final EmployeeRepository employeeRepository;

    public AdminEmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow( ()-> new RuntimeException("employee not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee exist = employeeRepository.findById(id).orElseThrow( ()-> new RuntimeException("employee not found") );

        exist.setName(employee.getName());
        exist.setEmail(employee.getEmail());
        exist.setRole(employee.getRole());

        return employeeRepository.save(exist);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
