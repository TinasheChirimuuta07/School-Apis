package com.classregister.school.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Data
public class RegisterRequestDTO {
    private Integer institutionId;
    private  boolean attendance;
    private Integer classId;
    private String studentFirstName;
    private String studentSurname;
    private LocalDateTime dateTime;
}
