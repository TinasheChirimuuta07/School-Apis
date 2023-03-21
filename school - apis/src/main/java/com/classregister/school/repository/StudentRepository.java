package com.classregister.school.repository;


import com.classregister.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(nativeQuery = true, value = "select  * from   student where institutionid=:institutionId and classid=:classId")
    List<Student> findAllByIdAndInstitution(Integer institutionId, Integer classId);

}


