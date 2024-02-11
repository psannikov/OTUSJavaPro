package ru.otus.pro.psannikov.password.changer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.password.changer.entities.Secret;

public interface SecretsRepository extends ListCrudRepository<Secret, Long> {
    @Query(value = "delete from secrets where credential_id = :credential_id", nativeQuery = true)
    void deleteByCredentialId(Long credential_id);
}
