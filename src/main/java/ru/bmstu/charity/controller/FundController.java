package ru.bmstu.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.charity.domain.Fund;
import ru.bmstu.charity.service.FundService;

@Controller
@RequestMapping("/fund/employee")
@RequiredArgsConstructor
public class FundController {

    private final FundService fundService;

    @GetMapping("{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("fund", fundService.findById(id).get());
        return "fund/fund";
    }

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("funds", fundService.findAll());
        return "fund/fund-list";
    }

    @GetMapping("/new")
    public String newFund(Model model) {
        model.addAttribute("fund", new Fund());
        return "fund/fund-form";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("fund") @Valid Fund fund,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "fund/fund-form";
        }
        fundService.save(fund);
        return "redirect:/fund/employee";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("fund", fundService.findById(id).get());
        return "fund/fund-edit-form";
    }

    @PatchMapping("/update/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("fund") Fund fund,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "fund/fund-edit-form";
        }
        fundService.update(id, fund);
        return "redirect:/fund/employee";
    }
}
