package ru.otus.pro.psannikov.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.dtos.ApprovalDtoRq;

public interface ApprovalRepository extends ListCrudRepository<ApprovalDtoRq, Long> {
    @Query("select name from subjects s where name=:name")
    public ApprovalDtoRq checkDataToApprove(String name);
}
