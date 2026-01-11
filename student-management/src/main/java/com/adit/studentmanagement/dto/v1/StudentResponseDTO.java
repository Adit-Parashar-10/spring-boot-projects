package com.adit.studentmanagement.dto.v1;

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
