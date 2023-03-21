package com.classregister.school.model;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="student_first_name")
    private String studentFirstName;
    @Column(name="student_surname")
    private String studentSurname;
    @Column(name="classid")
    private Integer classid;
    @Column(name="institutionid")
    private Integer institutionid;

    @Column(name="national_id")
    private String nationalId;


}
