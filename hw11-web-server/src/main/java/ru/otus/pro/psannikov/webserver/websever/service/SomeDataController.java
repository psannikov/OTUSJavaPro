package ru.otus.pro.psannikov.webserver.websever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.data.CashMachine;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.service.CashMachineService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Controller
public class SomeDataController {
    @Autowired
    CashMachineService cashMachineService;
    @Autowired
    CashMachine cashMachine;

    @GetMapping(value = "cachmachine")
    public String getMoney(Model model) {
        return "cachmachine";
    }
    @PostMapping(value = "getmoney")
    public String getMoney(Model model, String card, String pin, Integer value) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        model.addAttribute("value", value);
        List<Integer> takenAmount = cashMachineService.getMoney(cashMachine, card, pin, BigDecimal.valueOf(value));
        model.addAttribute("takenAmount",takenAmount);
        return "cachmachine";
    }
    @PostMapping(value = "putmoney")
    public String putMoney(Model model, String card, String pin, Integer count100, Integer count500, Integer count1000, Integer count5000) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        System.out.println(count100);
        System.out.println(count500);
        System.out.println(count1000);
        System.out.println(count5000);
        cashMachineService.putMoney(cashMachine, card, pin, Arrays.asList(count5000, count1000, count500, count100));
        model.addAttribute("putAmount", count100*100+count500*500+count1000*1000+count5000*5000);
        return "cachmachine";
    }
    @PostMapping(value = "checkbalance")
    public String checkBalance(Model model, String card, String pin) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        BigDecimal balance = cashMachineService.checkBalance(cashMachine, card, pin);
        model.addAttribute("balance", balance);
        return "cachmachine";
    }
    @PostMapping(value = "cahngepin")
    public String checkBalance(Model model, String card, String pin, String newpin) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        cashMachineService.changePin(card, pin, newpin);
        model.addAttribute("newpin", newpin);
        return "cachmachine";
    }
}
