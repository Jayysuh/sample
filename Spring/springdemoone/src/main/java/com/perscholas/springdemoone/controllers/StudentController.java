package com.perscholas.springdemoone.controllers;

import com.perscholas.springdemoone.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/student") //url name localhost:8080/student
    public String getStudent(Model model){
        Student student = new Student();
        student.setName("Jim");
        student.setRollNum(123);
        model.addAttribute("student", student); //binds student entity/model to view/ui
        return "student";
    }
}
