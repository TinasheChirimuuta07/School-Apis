package com.classregister.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table
public class Classes  {

    private static final long serialVersionUID= -6234057529255411648L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(
            fetch=FetchType.EAGER
    )
    @JoinColumn(
            name="institution",
            nullable=false,
            referencedColumnName = "id"
    )
    @JsonIgnore
    private Institution institution;


    private String code;

    private String nameOfClass;



}
