package ru.otus.pro.psannikov.password.changer.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.pro.psannikov.password.changer.dtos.DetailedCredentialsDto;
import ru.otus.pro.psannikov.password.changer.entities.Credential;

import java.util.Optional;

public interface CredentialsRepository extends ListCrudRepository<Credential, Long> {
    Optional<Credential> findByLogin(String login);
    @Query(value = "select * from detail_credentials where id = :id", nativeQuery = true)
    Optional<DetailedCredentialsDto> findDetailedCredentialById(Long id);
}
