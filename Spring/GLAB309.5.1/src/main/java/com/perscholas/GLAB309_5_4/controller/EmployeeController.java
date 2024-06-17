package com.perscholas.GLAB309_5_4.controller;

import com.perscholas.GLAB309_5_4.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {
    private Map<Long, Employee> employeeMap = new HashMap<>();

    //GET for displaying data in the form
    @GetMapping("/employeeform")
    public String empForm() {
        return "employeeform";
    }

    //POST for the create operation via the form's submission
    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("id", employee.getId());
        model.addAttribute("contactNumber",
                employee.getContactNumber());
        employeeMap.put(employee.getId(), employee);
        return "employeeView";
    }
}
