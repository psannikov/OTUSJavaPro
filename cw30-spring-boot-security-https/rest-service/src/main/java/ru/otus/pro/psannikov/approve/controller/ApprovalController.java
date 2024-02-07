package ru.otus.pro.psannikov.approve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.approve.data.Approval;

@RestController
public class ApprovalController {
    @GetMapping(value = "/approval")
    public Approval getApproval(@RequestParam(name = "id") Long id) {
        return new Approval(true);
    }
}

