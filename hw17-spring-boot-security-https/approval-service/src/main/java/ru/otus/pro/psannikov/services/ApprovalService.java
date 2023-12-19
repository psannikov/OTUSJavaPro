package ru.otus.pro.psannikov.services;

import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.data.Approval;
import ru.otus.pro.psannikov.dtos.ApprovalDtoRq;
import ru.otus.pro.psannikov.repositories.ApprovalRepository;

@Service
public class ApprovalService {
    private final ApprovalRepository approvalRepository;

    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    public Approval getApproval(Long subject_id, Long costumer_id, Long teacher_id) {
        ApprovalDtoRq approvalDtoRq = approvalRepository.checkDataToApprove(subject_id, costumer_id, teacher_id);
        Boolean res = (approvalDtoRq.getSubjectId() == subject_id &&
                approvalDtoRq.getCostumerId() == costumer_id &&
                approvalDtoRq.getTeacherId() == teacher_id) ? true : false;
        return new Approval(res);
    }
}
