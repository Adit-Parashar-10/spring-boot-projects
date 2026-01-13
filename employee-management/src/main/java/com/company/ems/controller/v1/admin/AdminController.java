package com.company.ems.controller.v1.admin;

import com.company.ems.service.admin.AdminEmployeeService;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    private final AdminEmployeeService adminEmployeeService;


    public AdminController(AdminEmployeeService adminEmployeeService) {
        this.adminEmployeeService = adminEmployeeService;
    }



}
