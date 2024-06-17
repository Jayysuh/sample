package com.GLAB309_8_2.studentlogin.impl;

import com.GLAB309_8_2.studentlogin.dto.StudentDto;
import com.GLAB309_8_2.studentlogin.model.Role;
import com.GLAB309_8_2.studentlogin.model.Student;
import com.GLAB309_8_2.studentlogin.repository.RoleRepository;
import com.GLAB309_8_2.studentlogin.repository.StudentRepository;
import com.GLAB309_8_2.studentlogin.service.StudentService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
This class implements the StudentService interface and provides
the actual service(s) for a student object.
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    /*
    The StudentServiceImpl constructor implements a “constructor-based injection,”
    which means that the dependencies required for this class are provided as
    arguments to the constructor. For Spring 4.3 and higher, the @Autowired
    annotation is not required as an annotation over the constructor.
     */
    public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        super();
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /*
    Saves student data and encrypted password to students table. The join
    table “students_roles” stores the primary key for role id and student id
    association.
     */
    @Override
    public void saveStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getFirstName() + " " +
                studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        // Encrypt the password using Spring Security
        student.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        student.setRoles(Arrays.asList(role));
        studentRepository.save(student);
    }
    /*
    If the student does not have a role, the method assigns/sets the role to
    “ROLE_ADMIN.”
     */
    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    //Finds a student by email.
    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    /*
    - Finds all students.
    - The object containing the list of students is passed into the Lambda
    expression as an input stream of students.
    - The map() is an intermediate operation that takes a function which is called
    for each student in the input stream. The function/method is
    mapToStudentDto(student). Each student object is mapped to a
    StudentDto object, validated and returned.
     */
    @Override
    public List<StudentDto> findAllStudents() {
        List<Student>students = studentRepository.findAll();
        return students.stream()
                .map((student) -> mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    /*
    - The method maps the Student object to the StudentDto
    object.
    - The Student object name returned from the database is parsed
    out as separate strings for firstName and lastName and set to a
    StudentDto object.
    - The StudentDto checks and validates empty fields.
     */
    private StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        String[] str = student.getName().split(" ");
        studentDto.setFirstName(str[0]);
        studentDto.setLastName(str[1]);
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }
}


