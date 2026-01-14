package com.company.ems.employee.controller.v1.admin;

import com.company.ems.employee.dto.v1.admin.AdminEmployeeResponseDTO;
import com.company.ems.employee.dto.v1.admin.AdminRequestDTO;
import com.company.ems.employee.entity.Employee;
import com.company.ems.employee.service.admin.AdminEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/employees")
public class AdminController {

    private final AdminEmployeeService adminEmployeeService;

    public AdminController(AdminEmployeeService adminEmployeeService) {
        this.adminEmployeeService = adminEmployeeService;
    }

    @GetMapping
    public ResponseEntity<List<AdminEmployeeResponseDTO>> getAllEmployee() {

        List<Employee> employees = adminEmployeeService.getAllEmployee();
        List<AdminEmployeeResponseDTO> responseList = new ArrayList<>();

        for (Employee e : employees) {
            AdminEmployeeResponseDTO dto = new AdminEmployeeResponseDTO();
            dto.setId(e.getId());
            dto.setName(e.getName());
            dto.setEmail(e.getEmail());
            dto.setRole(e.getRole());

            responseList.add(dto);
        }

        return ResponseEntity.ok(responseList);
    }

    @PostMapping
    public ResponseEntity<AdminEmployeeResponseDTO> createEmployee(
            @RequestBody AdminRequestDTO req) {

        Employee e = adminEmployeeService.createEmployee(req);

        AdminEmployeeResponseDTO dto = new AdminEmployeeResponseDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setRole(e.getRole());

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminEmployeeResponseDTO> getById(@PathVariable Long id) {

        Employee e = adminEmployeeService.getById(id);

        AdminEmployeeResponseDTO dto = new AdminEmployeeResponseDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setRole(e.getRole());

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminEmployeeResponseDTO> updateEmployee(
            @PathVariable Long id,
            @RequestBody AdminRequestDTO req) {

        Employee e = adminEmployeeService.updateEmployee(id, req);

        AdminEmployeeResponseDTO dto = new AdminEmployeeResponseDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setRole(e.getRole());

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        adminEmployeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
