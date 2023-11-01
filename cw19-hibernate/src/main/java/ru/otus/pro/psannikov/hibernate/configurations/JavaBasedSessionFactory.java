package ru.otus.pro.psannikov.hibernate.configurations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.otus.pro.psannikov.hibernate.entities.*;

import java.lang.invoke.MethodHandles;
import java.util.Properties;

public class JavaBasedSessionFactory {

    private static final Log LOGGER = LogFactory.getLog(MethodHandles.lookup().lookupClass());

    public static SessionFactory getJavaBasedSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            Properties props = new Properties();

            props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
            props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/otus-demo");
            props.put("hibernate.connection.username", "postgres");
            props.put("hibernate.connection.password", "postgres");
            props.put("hibernate.current_session_context_class", "thread");
            props.put("hibernate.hbm2ddl.auto", "create");

            configuration.setProperties(props);

            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Bank.class);
            configuration.addAnnotatedClass(City.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Email.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
            .build();

            LOGGER.info("Hibernate Java Config serviceRegistry created");

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            LOGGER.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}