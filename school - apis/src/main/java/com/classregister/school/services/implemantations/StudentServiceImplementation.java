package com.classregister.school.services.implemantations;

import com.classregister.school.dto.RegisterResponseDTO;
import com.classregister.school.model.Register;
import com.classregister.school.model.Student;
import com.classregister.school.repository.RegisterRepository;
import com.classregister.school.repository.StudentRepository;
import com.classregister.school.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentsService {
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private RegisterRepository registerRepository;


    @Override
    public Student getById(Integer id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()) {
            throw new EntityNotFoundException("Student not found");
        }

        return student.get();
    }

    @Override
    public Student saving(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public RegisterResponseDTO getRegister(Integer classid , Integer institution_id) {

        List<Student> students = studentRepo.findAllByIdAndInstitution(classid, institution_id);



        for (Student student : students) {
            Register register = new Register();
            register.setStudentSurname(student.getStudentSurname());
            register.setStudentFirstName(student.getStudentFirstName());
            register.setClassId(student.getClassid());
            register.setInstitutionId(student.getInstitutionid());
            register.setAttendance(true);
            register.setDateTime(LocalDate.now());
            registerRepository.save(register);

        }

        RegisterResponseDTO  registerResponseDTO = new RegisterResponseDTO();
        registerResponseDTO.setCode(200);
        registerResponseDTO.setMessage("Registration Successful");

return  registerResponseDTO ;
}

    @Override
    public List<Register> findRegisterBydate(LocalDate todaysdate) {
var returned = registerRepository.findRegisterBydateBydate(todaysdate);
if (returned.isEmpty()) {
    throw new EntityNotFoundException("Register with provided date not found ");
}
        return  returned ;
    }

    @Override
    public RegisterResponseDTO updateattendance(Integer id , Boolean attendance ) {
     //   if (id ==registerRepository.getRegister(id) ){
        //throw  new StudentNotFoundException("Student with Id " + id +"Not Found ");


      //   }

        var updatedRegister = registerRepository.getRegister(id);
        updatedRegister.setAttendance(attendance);
        registerRepository.save(updatedRegister);


//for (Register newregister : register)}
  //  else
     //   return registerRepository.updateattendance(id, attendance);}
        RegisterResponseDTO  registerResponseDTO = new RegisterResponseDTO();
        registerResponseDTO.setCode(200);
        registerResponseDTO.setMessage("student with ID " +id+ "Updated Successfully");
return  registerResponseDTO ;


}

    @Override
    public RegisterResponseDTO getnumberofdayspresent(Integer id) {
var registerrepo = registerRepository.getRegister(id);


        RegisterResponseDTO registerResponseDTO = new RegisterResponseDTO();
        registerResponseDTO.setMessage(registerrepo.getStudentSurname()+ " " + registerrepo.getStudentFirstName()+" Was Present For "+registerRepository.getPresentDays(id) + " Days" );
        registerResponseDTO.setCode(200);
        return registerResponseDTO;
    }


}
