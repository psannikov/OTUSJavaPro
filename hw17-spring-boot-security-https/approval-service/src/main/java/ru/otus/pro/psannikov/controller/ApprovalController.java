package ru.otus.pro.psannikov.controller;

import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.data.Approval;
import ru.otus.pro.psannikov.services.ApprovalService;

@RestController
@RequestMapping("/api/v1/approval")
public class ApprovalController {
    private final ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping()
    public Approval getApproval(@RequestParam String name) {
        return approvalService.getApproval(name);
    }
}

