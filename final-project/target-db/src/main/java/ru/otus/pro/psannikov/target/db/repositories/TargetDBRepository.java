package ru.otus.pro.psannikov.target.db.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.pro.psannikov.target.db.entities.Auth;

import java.util.Optional;

public interface TargetDBRepository extends ListCrudRepository<Auth, Long> {
    @Transactional
    @Query(value = "select change_password(:login, :password) from dual", nativeQuery = true)
    String changePassword(String login, String password);

    @Query(value = "select * from auths where login=:login order by 1 desc limit 1", nativeQuery = true)
    Optional<Auth> checkAuth(String login);
}
