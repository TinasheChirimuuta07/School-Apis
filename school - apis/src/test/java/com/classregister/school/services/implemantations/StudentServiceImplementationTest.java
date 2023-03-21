package com.classregister.school.services.implemantations;

import com.classregister.school.dto.RegisterResponseDTO;
import com.classregister.school.model.Register;
import com.classregister.school.model.Student;
import com.classregister.school.repository.RegisterRepository;
import com.classregister.school.repository.StudentRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplementationTest {
    @Mock
    private StudentRepository studentRepo;
    @Mock
    private RegisterRepository registerRepository;

    @InjectMocks
    private StudentServiceImplementation studentServiceImplementation;





    @Test
    void shouldGetStudentsById() {
       Student  student =  Student.builder().studentSurname("Doe").nationalId("32-2003").id(6).classid(78).studentFirstName("John").institutionid(90).build();

        when(studentRepo.findById(student.getId())).thenReturn(Optional.of(student));

        var std = studentServiceImplementation.getById(student.getId());

        assertEquals(student.getId(), std.getId());
    }

    @Test
    public void shouldGetStudentByIdThrowEntityNotFoundException() {
        assertThrows(EntityNotFoundException.class, () -> studentServiceImplementation.getById(66));

    }
    @Test
    public void dateOfRegisterNotAvailableException() {
        assertThrows(EntityNotFoundException.class, () -> studentServiceImplementation.findRegisterBydate(LocalDate.now()));

    }


    @Test
    void saving() {
        Student  student =  Student.builder().studentSurname("Doe").nationalId("32-2003").id(6).classid(78).studentFirstName("John").institutionid(90).build();
                when(studentRepo.save(student)).thenReturn(student);
        Student saved = studentServiceImplementation.saving(student);
        assertThat(saved.getStudentSurname()).isEqualTo(student.getStudentSurname());

    }

    @Test

    void getRegister() {
        int classId = 66;
        int institutionId = 666;
        Student student = Student.builder().studentSurname("Chirimuuta").studentFirstName("Tinashe").institutionid(666).classid(66).id(6).nationalId("threetwo").build();
        Register register = Register.builder().attendance(true).classId(student.getClassid()).institutionId(student.getInstitutionid()).dateTime(LocalDate.now())

                .studentFirstName(student.getStudentFirstName()).studentSurname(student.getStudentSurname()).build();

        when(studentRepo.findAllByIdAndInstitution(classId, institutionId)).thenReturn(List.of(student));
        when(registerRepository.save(register)).thenReturn(register);

       var found =  studentServiceImplementation.getRegister(classId,institutionId);
     assertThat(found).isNotNull();
     assertThat(register.getClassId()).isEqualTo(classId);

    }

    @Test
    void findRegisterByDate() {
        LocalDate localDate = LocalDate.now();

        Register register = Register.builder().attendance(true).classId(6).institutionId(666).dateTime(localDate).id(6).studentFirstName("Tinashe").studentSurname("Chirimuuta").build();

       when(registerRepository.findRegisterBydateBydate(localDate)).thenReturn(List.of(register));

       List<Register> registerBack = studentServiceImplementation.findRegisterBydate(localDate);
       assertThat(registerBack).isNotNull();


    }

    @Test
    void canUpdateAttendance() {
        Register register = Register.builder().attendance(true).classId(6).institutionId(666).dateTime(LocalDate.now()).id(6).studentFirstName("Tinashe").studentSurname("Chirimuuta").build();
        when(registerRepository.getRegister(6)).thenReturn(register);
        when(registerRepository.save(register)).thenReturn(register);

        //act
        RegisterResponseDTO response =  studentServiceImplementation.updateattendance(6,false);
        assertThat(response).isNotNull();

    }

    @Test
    void cangetnumberofdayspresent() {
        int idd = 6;
        Register register = Register.builder().attendance(true).classId(6).institutionId(666).dateTime(LocalDate.now()).id(6).studentFirstName("Tinashe").studentSurname("Chirimuuta").build();
        when(registerRepository.getRegister(idd)).thenReturn(register);

        RegisterResponseDTO responseDTO = studentServiceImplementation.getnumberofdayspresent(idd);
        assertThat(responseDTO).isNotNull();
        assertThat(register.getId()).isEqualTo(idd);
    }
}