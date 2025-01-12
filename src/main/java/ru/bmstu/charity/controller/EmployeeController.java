package ru.bmstu.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bmstu.charity.service.EmployeeService;

@Controller
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/home")
    public String home() {
        return "home/employee-home";
    }

    @GetMapping("profile")
    public String profile(Model model) {
        model.addAttribute("employee", employeeService.findCurrentEmployee().get());
        return "employee/employee-profile";
    }

    @GetMapping("{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id).get());
        return "employee/employee";
    }

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/employee-list";
    }
}