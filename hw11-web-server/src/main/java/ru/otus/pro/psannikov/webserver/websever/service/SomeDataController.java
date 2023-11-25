package ru.otus.pro.psannikov.webserver.websever.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;


@Controller
public class SomeDataController {
    @GetMapping(value = "cashmachine")
    public String people(Model model) {
        model.addAttribute("name", "Vasya");
        return "cashmachine";
    }

    @PostMapping(value = "cashmachine")
    public String add(Model model, String name) {
        model.addAttribute("name", name);
        return "cashmachine";
    }

    @GetMapping(value = "getmoney")
    public String getMoney(Model model) {
//        model.addAttribute("name", "Vasya");
        return "getmoney";
    }
    @PostMapping(value = "getmoney")
    public String getMoney(Model model, Integer card, Integer pin, Integer value) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        model.addAttribute("value", value);
        return "getmoney";
    }
}
