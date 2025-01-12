package ru.bmstu.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bmstu.charity.dto.ClientRegistrationDto;
import ru.bmstu.charity.dto.EmployeeRegistrationDto;
import ru.bmstu.charity.service.RegistrationService;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "auth/access-denied";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationDto", new ClientRegistrationDto());
        return "auth/register-client";
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute @Valid ClientRegistrationDto registrationDto,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/register-client";
        }

        try {
            registrationService.registerNewClient(registrationDto);
            return "redirect:/auth/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Ошибка регистрации: " + e.getMessage());
            return "auth/register-client";
        }
    }

    @GetMapping("/employee/register")
    public String showRegistrationFormForEmployee(Model model) {
        model.addAttribute("registrationDto", new EmployeeRegistrationDto());
        return "employee/employee-register";
    }

    @PostMapping("/employee/register")
    public String registerEmployee(@ModelAttribute @Valid EmployeeRegistrationDto registrationDto,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/register-client";
        }

        try {
            registrationService.registerNewEmployee(registrationDto);
            return "redirect:/employee";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Ошибка регистрации: " + e.getMessage());
            return "employee/employee-register";
        }
    }
}
