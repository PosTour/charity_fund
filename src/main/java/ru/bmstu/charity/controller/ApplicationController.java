package ru.bmstu.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.charity.domain.Application;
import ru.bmstu.charity.service.ApplicationService;
import ru.bmstu.charity.service.ServiceService;

@Controller
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ServiceService serviceService;

    @GetMapping("/new")
    public String newApplication(Model model) {
        model.addAttribute("application", new Application());
        model.addAttribute("services", serviceService.findAll());
        return "application/application-form";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("application") @Valid Application application,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "application/application-form";
        }
        applicationService.save(application);
        return "redirect:";
    }

    @PatchMapping("/employee/approve/{id}")
    public String approve(@PathVariable("id") int id) {
        applicationService.approve(id);
        return "redirect:";
    }

    @PatchMapping("/employee/disapprove/{id}")
    public String disapprove(@PathVariable("id") int id) {
        applicationService.disapprove(id);
        return "redirect:";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("application", applicationService.findById(id).get());
        return "application/application";
    }

    @GetMapping("/employee/fund/{id}")
    public String findByAllByFundId(@PathVariable("id") int id, Model model) {
        model.addAttribute("applications", applicationService.findAllByFundId(id));
        return "application/application-list";
    }

    @GetMapping("/employee")
    public String findAll(Model model) {
        model.addAttribute("applications", applicationService.findAll());
        return "application/application-list";
    }

    @GetMapping("/employee/approved")
    public String findApproved(Model model) {
        model.addAttribute("applications", applicationService.findApproved());
        return "application/application-list";
    }

    @GetMapping("/employee/disapproved")
    public String findDisapproved(Model model) {
        model.addAttribute("applications", applicationService.findDisapproved());
        return "application/application-list";
    }

    @GetMapping("/employee/pending")
    public String findPending(Model model) {
        model.addAttribute("applications", applicationService.findPending());
        return "application/application-list";
    }

    @GetMapping("/client")
    public String findByAllForCurrentClient(Model model) {
        model.addAttribute("applications", applicationService.findAllForCurrentClient());
        return "application/application-list";
    }

    @GetMapping("/employee/client/{id}")
    public String findByAllByClientId(@PathVariable("id") int id, Model model) {
        model.addAttribute("applications", applicationService.findAllByClientId(id));
        return "application/application-list";
    }

    @GetMapping("/employee/client/approved/{id}")
    public String findApprovedByClientId(@PathVariable("id") int id, Model model) {
        model.addAttribute("applications", applicationService.findApprovedByClientId(id));
        return "application/application-list";
    }

    @GetMapping("/employee/client/disapproved/{id}")
    public String findDisapprovedByClientId(@PathVariable("id") int id, Model model) {
        model.addAttribute("applications", applicationService.findDisapprovedByClientId(id));
        return "application/application-list";
    }

    @GetMapping("/employee/client/pending/{id}")
    public String findPendingByClientId(@PathVariable("id") int id, Model model) {
        model.addAttribute("applications", applicationService.findPendingByClientId(id));
        return "application/application-list";
    }
}
