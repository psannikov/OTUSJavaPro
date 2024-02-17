package ru.otus.pro.psannikov.configuration.db.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.pro.psannikov.configuration.db.entities.Secret;

import java.util.Optional;

public interface SecretsRepository extends ListCrudRepository<Secret, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from secrets where credential_id = :credential_id", nativeQuery = true)
    void deleteByCredentialId(Long credential_id);

    @Transactional
    @Modifying
    @Query(value = "insert into secrets (credential_id,secret) values (:id,pwd_gen(20,:information_system))", nativeQuery = true)
    void insertNewSecret(Long id, String information_system);

    @Query(value = "select secret from secrets where credential_id = :credentialId", nativeQuery = true)
    Optional<String> findByCredentialId(Long credentialId);
}
