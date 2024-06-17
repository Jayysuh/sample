package com.GLAB309_8_2.studentlogin.security;


/*
To load Student details, the class implements the Spring security
interface, UserDetailsService. The class will use the interface to look
up username and password, and grant authorities to any student.
This is done by overriding the loadUserByUsername() method and
providing custom implementation to lookup Student login credentials.
Student objects are authenticated if email and password are valid.
 */
import com.GLAB309_8_2.studentlogin.model.Student;
import com.GLAB309_8_2.studentlogin.repository.StudentRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class CustomStudentDetailsService implements UserDetailsService {
    private StudentRepository studentRepository;
    /*
    The CustomStudentDetailsServicel() constructor implements a
    “constructor-based injection.” which means that the dependencies required for
    this class are provided as arguments to the constructor. For Spring 4.3 and
    higher, the @Autowired annotation is not required as an annotation over the
    constructor.

     */
    public CustomStudentDetailsService(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    /*
    - Uses the studentRepository to find the student by email.
    - This service will return the student details in the UserDetails object.
    - If the student object is null - (email was not found) it throws a
    UserNameNotFoundException.
     */
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(usernameOrEmail);
        if(student != null) {
            return new
                    org.springframework.security.core.userdetails.User(student.getEmail(),
                    student.getPassword(),
                    student.getRoles().stream()
                            .map((role) -> new
                                    SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
