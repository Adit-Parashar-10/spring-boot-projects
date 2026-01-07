package com.adit.studentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class StudentRequestDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String course;
}
