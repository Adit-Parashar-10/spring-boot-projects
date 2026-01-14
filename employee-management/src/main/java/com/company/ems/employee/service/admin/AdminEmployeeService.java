package com.company.ems.employee.service.admin;

import com.company.ems.employee.dto.v1.admin.AdminRequestDTO;
import com.company.ems.employee.entity.Employee;
import com.company.ems.employee.repository.EmployeeRepository;
import com.company.ems.employee.service.EmployerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminEmployeeService")
public class AdminEmployeeService implements EmployerService {

    private final EmployeeRepository employeeRepository;

    public AdminEmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee createEmployee(AdminRequestDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setRole((dto.getRole()));

        return employeeRepository.save(employee);
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

    public Employee updateEmployee(Long id, AdminRequestDTO dto) {

        Employee exist = employeeRepository.findById(id).orElseThrow( ()-> new RuntimeException("employee not found") );

        exist.setName(dto.getName());
        exist.setEmail(dto.getEmail());
        exist.setRole(dto.getRole());

        return employeeRepository.save(exist);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        AdminRequestDTO dto = new AdminRequestDTO();
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setRole(employee.getRole());

        return updateEmployee(id, dto);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
