package com.GLAB309_8_2.studentlogin.service;

import com.GLAB309_8_2.studentlogin.model.Student;
import com.GLAB309_8_2.studentlogin.dto.StudentDto;

import java.util.List;

/*
This interface will provide an interface to services for the Student
object.

Notice the saveStudent() method receives the StudentDto object as an
argument and not a Student object. This means that the Student object was
mapped to a studentDto object. The studentDto object splits the student’s full
name into two separate strings: firstname and lastname. It then checks and
validates if a field is empty. If empty, the dto returns an error message. So, dto’s
can be used to validate the incoming student data from a request and can filter
the type of student data transferred within the application and in a response.
 */
public interface StudentService {
    void saveStudent(StudentDto studentDto);
    Student findStudentByEmail(String email);
    List<StudentDto> findAllStudents();
}