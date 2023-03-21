package com.classregister.school.services;

import com.classregister.school.dto.RegisterResponseDTO;
import com.classregister.school.model.Register;
import com.classregister.school.model.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface StudentsService {


    Student getById(Integer id);
    Student saving  (Student student);

   RegisterResponseDTO getRegister(Integer institution_id, Integer classId);

   List<Register>  findRegisterBydate (LocalDate todaysdate);

    RegisterResponseDTO updateattendance (Integer id , Boolean attendance);
   RegisterResponseDTO getnumberofdayspresent  (Integer id );


}


