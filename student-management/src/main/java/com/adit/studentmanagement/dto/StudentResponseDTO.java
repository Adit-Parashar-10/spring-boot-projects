package com.adit.studentmanagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String course;
}
