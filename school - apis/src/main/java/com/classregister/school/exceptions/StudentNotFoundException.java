package com.classregister.school.exceptions;

public class StudentNotFoundException extends  RuntimeException{

    public StudentNotFoundException(String notfound){

        super(notfound);
    }
}
