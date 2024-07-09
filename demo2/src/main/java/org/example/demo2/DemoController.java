package org.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/employee/form")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm"; // Assuming "employeeForm.html" exists in templates directory
    }

    @PostMapping("/employee/submit")
    public String submitForm(@ModelAttribute("employee") Employee employee, Model model) {
        employeeRepo.save(employee);
        model.addAttribute("firstName", employee.getFirstName());
        model.addAttribute("lastName", employee.getLastName());
        model.addAttribute("email", employee.getEmail());
        model.addAttribute("phone", employee.getPhone());
        //model.addAttribute("department", employee.getDepartment());
        return "employeeSuccess"; // Assuming "employeeSuccess.html" exists in templates directory
    }
}
