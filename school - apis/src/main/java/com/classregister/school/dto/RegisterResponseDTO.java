package com.classregister.school.dto;

import com.classregister.school.model.Register;
import com.classregister.school.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDTO {
    private  String message;
    private Integer code;

}
