package com.classregister.school.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Institution")
//@Table(name = "institution")
public class Institution {
    private static final long serialVersionUID= -6234057529255411648L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;


    @Column(name="institution_name")
    private String institutionName;
    @Column(name="institution_address")
    private String institutionAddress;
    @Column(name="institution_code")
    private String institutionCode;
    private String phone;
    private String email;



}