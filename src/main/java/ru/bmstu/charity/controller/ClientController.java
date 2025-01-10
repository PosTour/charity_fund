package ru.bmstu.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("client")
public class ClientController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard/client-dashboard";
    }
}