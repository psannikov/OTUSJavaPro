package ru.otus.pro.psannikov.spring.boot.security.https.sevices;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.otus.pro.psannikov.spring.boot.security.https.dtos.CreateOrUpdateSubjectDtoRq;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectsService {
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    Optional<Subject> findById(Long id);
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    List<Subject> findAll();
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    void createNewSubject(CreateOrUpdateSubjectDtoRq createOrUpdateSubjectDtoRq) throws Exception;
}
