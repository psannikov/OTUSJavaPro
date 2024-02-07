package ru.otus.pro.psannikov.services;

import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.data.Approval;
import ru.otus.pro.psannikov.dtos.ApprovalDtoRq;
import ru.otus.pro.psannikov.repositories.ApprovalRepository;

import java.util.Optional;

@Service
public class ApprovalService {
    private final ApprovalRepository approvalRepository;

    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    public Approval getApproval(String name) {
        Optional<ApprovalDtoRq> approvalDtoRq = Optional.ofNullable(approvalRepository.checkDataToApprove(name));
        Boolean res = approvalDtoRq.isEmpty();
        return new Approval(res);
    }
}
