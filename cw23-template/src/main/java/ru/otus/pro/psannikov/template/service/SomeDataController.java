package ru.otus.pro.psannikov.template.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;


@Controller
public class SomeDataController {
    @GetMapping(value = "people")
    public String people(Model model) {
        model.addAttribute("name", "Vasya");
        return "people";
    }

    @PostMapping(value = "people")
    public String add(Model model, String name) {
        model.addAttribute("name", name);
        model.addAttribute("time", LocalDate.now().toString());
        return "people";
    }
}
