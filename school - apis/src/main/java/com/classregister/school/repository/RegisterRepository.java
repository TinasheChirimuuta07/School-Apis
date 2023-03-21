package com.classregister.school.repository;


import com.classregister.school.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer> {
    @Query( nativeQuery = true , value = "select * from register where todays_date=:dateTime")
    List<Register> findRegisterBydateBydate(LocalDate dateTime);


   @Query(nativeQuery = true , value = "select * from  register  where id=:id")
     Register getRegister(Integer id);

    @Query(nativeQuery = true , value = "select count(attendance) , student_surname  from register where id=:id and attendance=1")
    Integer getPresentDays(Integer id);

}




