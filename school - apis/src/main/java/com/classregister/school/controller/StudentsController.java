package com.classregister.school.controller;

import com.classregister.school.dto.RegisterResponseDTO;
import com.classregister.school.model.Register;
import com.classregister.school.model.Student;
import com.classregister.school.services.StudentsService;
import com.classregister.school.services.implemantations.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentsController {
  @Autowired
  private StudentsService studentsservice ;
  @Autowired
  private StudentServiceImplementation studentServiceImplementation;

  @PostMapping("/register")
  public Student saving (@RequestBody Student student){
    return studentsservice.saving(student);

  }


  @GetMapping("/get")
  public String get (){return "bh";}
  @GetMapping("/register/{institution_id}/{classId}")
  public ResponseEntity<RegisterResponseDTO> getRegister (@PathVariable("classId") Integer classid , @PathVariable("institution_id") Integer institution_id ){
    return ResponseEntity.ok(studentServiceImplementation.getRegister(classid,institution_id));
  }
  @GetMapping("/get_register_by_date/{todays_date}")
  public List<Register>  findregisterBydate(   @PathVariable("todays_date")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate todaysdate){

    return studentServiceImplementation.findRegisterBydate(todaysdate);
  }
  @GetMapping("/update_attendance/{id}/{attendance}")
  public ResponseEntity<RegisterResponseDTO> updateattendance(@PathVariable("id") Integer id , @PathVariable("attendance") Boolean attendance){
    return ResponseEntity.ok(studentServiceImplementation.updateattendance(id,attendance));


  }
  @GetMapping("/get_number_of_days_present/{id}")
  public ResponseEntity<RegisterResponseDTO> getnumberofdayspresent(@PathVariable("id") Integer id ){

    return ResponseEntity.ok(studentServiceImplementation.getnumberofdayspresent(id)) ;
  }
}
