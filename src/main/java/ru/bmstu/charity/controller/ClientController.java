package ru.bmstu.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bmstu.charity.service.ClientService;

@Controller
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/home")
    public String home() {
        return "home/client-home";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("client", clientService.findCurrentClient().get());
        return "client/client-profile";
    }

    @GetMapping("/employee/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientService.findById(id).get());
        return "client/client";
    }

    @GetMapping("/employee")
    public String findAll(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "client/client-list";
    }
}