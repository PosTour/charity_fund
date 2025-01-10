package ru.bmstu.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.charity.domain.Service;
import ru.bmstu.charity.service.ServiceService;

@Controller
@RequestMapping("/service/employee")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping("{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("service", serviceService.findById(id).get());
        return "service/service";
    }

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("services", serviceService.findAll());
        return "service/service-list";
    }

    @GetMapping("/new")
    public String newService(Model model) {
        model.addAttribute("service", new Service());
        return "service/service-form";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("service") @Valid Service service,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "service/service-form";
        }
        serviceService.save(service);
        return "redirect:";
    }
}
