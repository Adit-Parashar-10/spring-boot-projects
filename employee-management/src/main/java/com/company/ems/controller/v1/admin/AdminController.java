package com.company.ems.controller.v1.admin;

import com.company.ems.dto.v1.admin.AdminRequestDTO;
import com.company.ems.entity.Employee;
import com.company.ems.service.admin.AdminEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/employees")
public class AdminController {

    private final AdminEmployeeService adminEmployeeService;


    public AdminController(AdminEmployeeService adminEmployeeService) {
        this.adminEmployeeService = adminEmployeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> emp =  adminEmployeeService.getAllEmployee();
        return ResponseEntity.ok(emp);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody AdminRequestDTO dto){

        Employee created = adminEmployeeService.createEmployee(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){

        Employee fetched = adminEmployeeService.getById(id);

        return ResponseEntity.ok(fetched);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        adminEmployeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable Long id, Employee employee){
        Employee updated = adminEmployeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updated);
    }



}
