package com.classregister.school.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@RequiredArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
//@Table(name="register")

public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "institution_id")
    private Integer institutionId;
    @Column(name = "attendance")
    private  boolean attendance;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "student_first_name")
    private String studentFirstName;
    @Column(name = "student_surname")
    private String studentSurname;
    @Column(name = "todays_date")
    private LocalDate dateTime;



}
