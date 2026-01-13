package com.company.ems.dto.v1.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminRequestDTO {

    private String name;
    private String email;
    private String role;

}
