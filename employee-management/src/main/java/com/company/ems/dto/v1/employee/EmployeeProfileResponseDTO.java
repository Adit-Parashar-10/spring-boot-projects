package com.company.ems.dto.v1.employee;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeProfileResponseDTO {

    private Long id;
    private String name;
    private String email;

}
