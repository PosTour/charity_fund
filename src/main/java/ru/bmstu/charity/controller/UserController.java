package ru.bmstu.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bmstu.charity.service.UserService;

@Controller
@RequestMapping("user/employee")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id).get());
        return "user/user";
    }

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/user-list";
    }
}
