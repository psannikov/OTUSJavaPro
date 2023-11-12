package ru.otus.pro.psannikov.jpql.demo;

import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.pro.psannikov.jpql.core.repository.DataTemplateHibernate;
import ru.otus.pro.psannikov.jpql.core.repository.HibernateUtils;
import ru.otus.pro.psannikov.jpql.core.sessionmanager.TransactionManagerHibernate;
import ru.otus.pro.psannikov.jpql.crm.dbmigrations.MigrationsExecutorFlyway;
import ru.otus.pro.psannikov.jpql.crm.model.Addres;
import ru.otus.pro.psannikov.jpql.crm.model.Client;
import ru.otus.pro.psannikov.jpql.crm.model.Phone;
import ru.otus.pro.psannikov.jpql.crm.service.DbServiceClientImpl;

import java.util.Arrays;

public class DbServiceDemo {

    private static final Logger log = LoggerFactory.getLogger(DbServiceDemo.class);

    public static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    public static void main(String[] args) {
        var configuration = new Configuration().configure(HIBERNATE_CFG_FILE);

        var dbUrl = configuration.getProperty("hibernate.connection.url");
        var dbUserName = configuration.getProperty("hibernate.connection.username");
        var dbPassword = configuration.getProperty("hibernate.connection.password");
        new MigrationsExecutorFlyway(dbUrl, dbUserName, dbPassword).executeMigrations();
        try {
        var sessionFactory = HibernateUtils.buildSessionFactory(configuration, Client.class);


        var transactionManager = new TransactionManagerHibernate(sessionFactory);

        var clientTemplate = new DataTemplateHibernate<>(Client.class);

        var dbServiceClient = new DbServiceClientImpl(transactionManager, clientTemplate);

            dbServiceClient.saveClient(new Client("Vasya", new Addres("Main St"), Arrays.asList(new Phone("9876543210"), new Phone("654321"))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        dbServiceClient.saveClient(new Client("dbServiceFirst"));
//
//        var clientSecond = dbServiceClient.saveClient(new Client("dbServiceSecond"));
//        var clientSecondSelected = dbServiceClient.getClient(clientSecond.getId())
//                .orElseThrow(() -> new RuntimeException("Client not found, id:" + clientSecond.getId()));
//        log.info("clientSecondSelected:{}", clientSecondSelected);
//
//        dbServiceClient.saveClient(new Client(clientSecondSelected.getId(), "dbServiceSecondUpdated"));
//        var clientUpdated = dbServiceClient.getClient(clientSecondSelected.getId())
//                .orElseThrow(() -> new RuntimeException("Client not found, id:" + clientSecondSelected.getId()));
//        log.info("clientUpdated:{}", clientUpdated);
//
//        log.info("All clients");
//        dbServiceClient.findAll().forEach(client -> log.info("client:{}", client));

    }
}
