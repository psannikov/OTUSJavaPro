package ru.otus.pro.psannikov.cache.engine.core;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.pro.psannikov.cache.engine.HomeWork;

import javax.sql.DataSource;

public class Migration {
    private static final Logger log = LoggerFactory.getLogger(Migration.class);
    public static void flywayMigrations(DataSource dataSource) {
        log.info("db migration started...");
        var flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:/db/migration")
                .load();
        flyway.migrate();
        log.info("db migration finished.");
        log.info("***");
    }
}
