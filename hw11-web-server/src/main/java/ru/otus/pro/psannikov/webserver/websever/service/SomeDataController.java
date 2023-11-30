package ru.otus.pro.psannikov.webserver.websever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.data.CashMachine;
import ru.otus.pro.psannikov.webserver.cashmachine.machine.service.CashMachineService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@Controller
public class SomeDataController {
    private final CashMachineService cashMachineService;
    private final CashMachine cashMachine;
    private final String endpoint = "cachmachine";
    public SomeDataController(CashMachine cashMachine, CashMachineService cashMachineService) {
        this.cashMachineService = cashMachineService;
        this.cashMachine = cashMachine;
    }

    @GetMapping(value = endpoint)
    public String getMoney(Model model) {
        return endpoint;
    }

    @PostMapping(value = "getmoney")
    public String getMoney(Model model, String card, String pin, Integer value) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        model.addAttribute("value", value);
        List<Integer> takenAmount = cashMachineService.getMoney(cashMachine, card, pin, BigDecimal.valueOf(value));
        model.addAttribute("takenAmount", takenAmount);
        return endpoint;
    }

    @PostMapping(value = "putmoney")
    public String putMoney(Model model, String card, String pin, Integer value) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        List<Integer> notes = getNotesByValue(value);
        Integer putAmount = notes.get(0) * 100 + notes.get(1) * 500 + notes.get(2) * 1000 + notes.get(3) * 5000;
        cashMachineService.putMoney(cashMachine, card, pin, notes);
        model.addAttribute("putAmount", putAmount);
        return endpoint;
    }

    @PostMapping(value = "checkbalance")
    public String checkBalance(Model model, String card, String pin) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        BigDecimal balance = cashMachineService.checkBalance(cashMachine, card, pin);
        model.addAttribute("balance", balance);
        return endpoint;
    }

    @PostMapping(value = "cahngepin")
    public String checkBalance(Model model, String card, String pin, String newpin) {
        model.addAttribute("card", card);
        model.addAttribute("pin", pin);
        cashMachineService.changePin(card, pin, newpin);
        model.addAttribute("newpin", newpin);
        return endpoint;
    }
    public List<Integer> getNotesByValue(int value) {
        List<Integer> res = Arrays.asList(0, 0, 0, 0);
        int [] notesVal = new int [] {100,500,1000,5000};
        for (int i = res.size() - 1; i >=0; i--) {
            res.set(i,value/notesVal[i]);
            value = value%notesVal[i];
        }
        return res;
    }
}
