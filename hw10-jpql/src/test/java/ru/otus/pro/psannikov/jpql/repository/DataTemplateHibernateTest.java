package ru.otus.pro.psannikov.jpql.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.pro.psannikov.jpql.base.AbstractHibernateTest;
import ru.otus.pro.psannikov.jpql.crm.model.Address;
import ru.otus.pro.psannikov.jpql.crm.model.Client;
import ru.otus.pro.psannikov.jpql.crm.model.Phone;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class DataTemplateHibernateTest extends AbstractHibernateTest {

    @Test
    @DisplayName(" корректно сохраняет, изменяет и загружает клиента по заданному id")
    void shouldSaveAndFindCorrectClientById() {

        var client = new Client(null, "Vasya", new Address( "AnyStreet"), List.of(new Phone( "13-555-22"),
                new Phone( "14-666-333")));


        //when
        var savedClient = transactionManager.doInTransaction(session -> {
            clientTemplate.insert(session, client);
            return client;
        });

        //then
        assertThat(savedClient.getId()).isNotNull();
        assertThat(savedClient.getName()).isEqualTo(client.getName());

        //when
        var loadedSavedClient = transactionManager.doInReadOnlyTransaction(
                session -> clientTemplate.findById(session, savedClient.getId())
                        .map(Client::clone)
        );

        //then
        assertThat(loadedSavedClient).isPresent().get()
                .usingRecursiveComparison()
                .isEqualTo(savedClient);

        //when
        savedClient.setName("updatedName");
        transactionManager.doInTransaction(session -> {
            clientTemplate.update(session, savedClient);
            return null;
        });

        //then
        Optional<Client> loadedClient = transactionManager.doInReadOnlyTransaction(
                session -> clientTemplate.findById(session, savedClient.getId())
                        .map(Client::clone)
        );
        assertThat(loadedClient).isPresent();
        assertThat(loadedClient).get()
                .usingRecursiveComparison()
                .isEqualTo(savedClient);

        //when
        var clientList = transactionManager.doInReadOnlyTransaction(session ->
                clientTemplate.findAll(session).stream()
                        .map(Client::clone).collect(Collectors.toList())
        );

        //then
        assertThat(clientList.size()).isEqualTo(1);
        assertThat(clientList.get(0))
                .usingRecursiveComparison()
                .isEqualTo(savedClient);


        //when
        clientList = transactionManager.doInReadOnlyTransaction(session ->
                clientTemplate.findByEntityField(session, "name", "updatedName")
                        .stream().map(Client::clone).collect(Collectors.toList())
        );

        //then
        assertThat(clientList.size()).isEqualTo(1);
        assertThat(clientList.get(0))
                .usingRecursiveComparison()
                .isEqualTo(savedClient);
    }
}
