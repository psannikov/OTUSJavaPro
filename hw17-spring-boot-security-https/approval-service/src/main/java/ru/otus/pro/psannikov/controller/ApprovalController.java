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
    public Approval getApproval(@RequestParam Long subject_id, @RequestParam Long costumer_id, @RequestParam Long teacher_id) {
        return approvalService.getApproval(subject_id, costumer_id, teacher_id);
    }
}

