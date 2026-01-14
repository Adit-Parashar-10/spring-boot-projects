package com.company.ems.employee.controller.v1.employee;

import com.company.ems.employee.dto.v1.employee.EmployeeProfileResponseDTO;
import com.company.ems.employee.dto.v1.employee.EmployeeRequestDTO;
import com.company.ems.employee.entity.Employee;
import com.company.ems.employee.service.employee.EmployeeServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee/profile")
public class EmployeeController {

    private final EmployeeServiceImplementation employeeService;

    public EmployeeController(EmployeeServiceImplementation employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProfileResponseDTO> getMyProfile(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);

        EmployeeProfileResponseDTO res = new EmployeeProfileResponseDTO();

        res.setId(employee.getId());
        res.setName(employee.getName());
        res.setEmail(employee.getEmail());

        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeProfileResponseDTO> updateMyProfile(@PathVariable Long id, @RequestBody EmployeeRequestDTO dto) {

        Employee updated = employeeService.updateEmployee(id, dto);

        EmployeeProfileResponseDTO res = new EmployeeProfileResponseDTO();

        res.setId(updated.getId());
        res.setName(updated.getName());
        res.setEmail(updated.getEmail());


        return ResponseEntity.ok(res);
    }
}
