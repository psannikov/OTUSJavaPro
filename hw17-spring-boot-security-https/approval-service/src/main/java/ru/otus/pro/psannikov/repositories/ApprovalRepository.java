package ru.otus.pro.psannikov.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.dtos.ApprovalDtoRq;

public interface ApprovalRepository extends ListCrudRepository<ApprovalDtoRq, Long> {
    @Query("select (select id from subjects s where id=:subject_id) subject_id,\n" +
            "(select id from costumers s where id=:costumer_id) costumer_id,\n" +
            "(select id from teachers s where id=:teacher_id) teacher_id")
    public ApprovalDtoRq checkDataToApprove(Long subject_id, Long costumer_id, Long teacher_id);
}
