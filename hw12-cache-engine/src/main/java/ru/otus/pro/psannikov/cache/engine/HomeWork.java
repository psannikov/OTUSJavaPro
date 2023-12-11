package ru.otus.pro.psannikov.cache.engine;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.pro.psannikov.cache.engine.cache.WeakCache;
import ru.otus.pro.psannikov.cache.engine.cache.WeakCacheImpl;
import ru.otus.pro.psannikov.cache.engine.core.repository.executor.DbExecutorImpl;
import ru.otus.pro.psannikov.cache.engine.core.sessionmanager.TransactionRunnerJdbc;
import ru.otus.pro.psannikov.cache.engine.crm.datasource.DriverManagerDataSource;
import ru.otus.pro.psannikov.cache.engine.crm.model.Client;
import ru.otus.pro.psannikov.cache.engine.crm.model.Manager;
import ru.otus.pro.psannikov.cache.engine.crm.service.DbServiceClientImpl;
import ru.otus.pro.psannikov.cache.engine.crm.service.DbServiceManagerImpl;
import ru.otus.pro.psannikov.cache.engine.mapper.DataTemplateJdbc;
import ru.otus.pro.psannikov.cache.engine.mapper.EntityClassMetaData;
import ru.otus.pro.psannikov.cache.engine.mapper.EntitySQLMetaData;

import javax.sql.DataSource;

import static ru.otus.pro.psannikov.cache.engine.core.Migration.flywayMigrations;

public class HomeWork {
    private static final String URL = "jdbc:postgresql://localhost:5430/demoDB";
    private static final String USER = "usr";
    private static final String PASSWORD = "pwd";

    private static final Logger log = LoggerFactory.getLogger(HomeWork.class);

    public static void main(String[] args) {
        var dataSource = new DriverManagerDataSource(URL, USER, PASSWORD);
        flywayMigrations(dataSource);
        var transactionRunner = new TransactionRunnerJdbc(dataSource);
        var dbExecutor = new DbExecutorImpl();
        WeakCache<String, Client> weakCache = new WeakCacheImpl<>();
        int iterations = 1000;

        EntitySQLMetaData entitySQLMetaDataClient = null; //= new EntitySQLMetaDataImpl(entityClassMetaDataClient);
        var dataTemplateClient = new DataTemplateJdbc<Client>(dbExecutor, entitySQLMetaDataClient, Client.class); //реализация DataTemplate, универсальная

        var dbServiceClient = new DbServiceClientImpl(transactionRunner, dataTemplateClient);
        long timeBeforeDB = System.currentTimeMillis();
        for (int i = 0; i <= iterations; i++) {
            var client = dbServiceClient.saveClient(new Client("Client #" + i));
            var clientSecondSelected = dbServiceClient.getClient(client.getId())
                    .orElseThrow(() -> new RuntimeException("Client not found, id:" + client.getId()));
        }
        long timeAfterDB = System.currentTimeMillis();
        long timeBeforeCache = System.currentTimeMillis();
        for (int i = 0; i <= iterations; i++) {
            String key = "Client #" + i;
            var client = new Client(key);
            weakCache.put(key,client);
        }
        long timeAfterCache = System.currentTimeMillis();
        log.info("Время работы с БД :" + (timeAfterDB - timeBeforeDB));
        log.info("Время работы с КЭШом :" + (timeAfterCache - timeBeforeCache));
    }
}
